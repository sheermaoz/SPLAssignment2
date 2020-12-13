package bgu.spl.mics.application.services;

import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.messages.BombDestroyerEvent;
import bgu.spl.mics.application.messages.TerminationBroadcast;

/**
 * LandoMicroservice
 * You can add private fields and public methods to this class.
 * You MAY change constructor signatures and even add new public constructors.
 */
public class LandoMicroservice  extends MicroService {

    private final long duration;

    public LandoMicroservice(long duration) {
        super("Lando");
        this.duration = duration;
    }

    @Override
    protected void initialize() {
        subscribeBroadcast(TerminationBroadcast.class, (ev)->{
            terminate();
        });
        subscribeEvent(BombDestroyerEvent.class, (ev)->{
            try
            {
                Thread.sleep(duration);
            }
            catch (InterruptedException e){}
            complete(ev, true);
        });
    }

    protected void close(){
        diary.setLandoTerminate(System.currentTimeMillis());
    }

}
