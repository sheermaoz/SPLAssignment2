package bgu.spl.mics.application.services;
import java.util.ArrayList;
import java.util.List;

import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.messages.*;
import bgu.spl.mics.application.passiveObjects.*;
import bgu.spl.mics.Future;

/**
 * LeiaMicroservices Initialized with Attack objects, and sends them as  {@link AttackEvent}.
 * This class may not hold references for objects which it is not responsible for:
 * {@link AttackEvent}.
 *
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class LeiaMicroservice extends MicroService {
    private Attack[] attacks;
    private List<Future<Boolean>> futures;
    private int attacksCompleted;
	
    public LeiaMicroservice(Attack[] attacks) {
        super("Leia");
        this.attacks = attacks;
        this.futures = new ArrayList<>();
        attacksCompleted = 0;
    }

    @Override
    protected void initialize() {

        subscribeBroadcast(TerminationBroadcast.class, (ev)->{
            terminate();
        });
        subscribeEvent(FinishedAttackEvent.class, (event) ->{
            attacksCompleted++;
            if (attacksCompleted == attacks.length)
            {
                sendBroadcast(new FinishedAttacksBroadcast());
                Future<Boolean> r2d2Future = sendEvent(new DeactivationEvent());
                r2d2Future.get();
                Future<Boolean> landoFuture = sendEvent(new BombDestroyerEvent());
                landoFuture.get();
                sendBroadcast(new TerminationBroadcast());
                
            }
        });
        
        for (Attack attack : attacks)
        {
            Future<Boolean> future = sendEvent(new AttackEvent(attack));
            futures.add(future);
        }

    }

    protected void close(){
        diary.setLeiaTerminate(System.currentTimeMillis());
    }

}
