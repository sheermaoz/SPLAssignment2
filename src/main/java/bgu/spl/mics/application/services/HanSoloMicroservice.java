package bgu.spl.mics.application.services;

import java.util.List;
import java.util.Arrays;
import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.messages.AttackEvent;
import bgu.spl.mics.application.messages.FinishedAttackEvent;
import bgu.spl.mics.application.messages.FinishedAttacksBroadcast;
import bgu.spl.mics.application.messages.TerminationBroadcast;
import bgu.spl.mics.application.passiveObjects.Ewoks;

/**
 * HanSoloMicroservices is in charge of the handling {@link AttackEvent}.
 * This class may not hold references for objects which it is not responsible for:
 * {@link AttackEvent}.
 *
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class HanSoloMicroservice extends MicroService {
    public HanSoloMicroservice() {
        super("Han");
    }


    @Override
    protected void initialize() {
        subscribeBroadcast(TerminationBroadcast.class, (ev)->{
            terminate();
        });
        subscribeBroadcast(FinishedAttacksBroadcast.class, (br)->{
            diary.setHanSoloFinish(System.currentTimeMillis());
        });

        this.subscribeEvent(AttackEvent.class, (ev) ->{
            List<Integer> tempSerials = ev.getSerials();   //init serials sorted array
            int[] serials = makeArray(tempSerials);
            Arrays.sort(serials);

            Ewoks ewoks = Ewoks.getInstance();  //allocating resources
            ewoks.AcquireAll(serials);

            try     //act
            {
                Thread.sleep(ev.getTime());
            }
            catch (InterruptedException e){}
            diary.addAttack();
            ewoks.ReleaseAll(serials);
            sendEvent(new FinishedAttackEvent());
            complete(ev, true);
        });
    }

    private int[] makeArray (List<Integer> serials){
        int[] result = new int[serials.size()];
        for(int i=0; i<serials.size(); i++){
            result[i] = serials.get(i);
        }
        return result;
    }

    protected void close(){
        diary.setHanSoloTerminate(System.currentTimeMillis());
    }
}
