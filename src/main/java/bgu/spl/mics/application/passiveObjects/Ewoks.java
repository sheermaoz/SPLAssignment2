package bgu.spl.mics.application.passiveObjects;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import bgu.spl.mics.Message;
import bgu.spl.mics.MessageBusImpl;
import bgu.spl.mics.MicroService;

/**
 * Passive object representing the resource manager.
 * <p>
 * This class must be implemented as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private methods and fields to this class.
 */
public class Ewoks {

    private static Ewoks instance = null;
    private static Ewok[] ewoks;



    private static class EwoksHolder
    {
        private static Ewoks instance = new Ewoks();
    }

    public static Ewoks getInstance()
    {
        return Ewoks.EwoksHolder.instance;
    }

    private Ewoks(){}

    /**
     * initializes the ewoks array
     * @param num : number of ewoks exists
     */
    public static void init(int num){
        ewoks = new Ewok[num];
        for (int i = 0; i < num; i++)
        {
            ewoks[i] = new Ewok(i+1);
        }
    }

    /**
     * the method gets a serials array, each microservice try to acquire all of the
     * ewoks with those serials together if it's possible, else the microservice will
     * wait for them to release and then acquire them.
     * @param serials : the serials of the ewoks required for the attack
    */

    public void AcquireAll(int[] serials){
        for(int i=0; i<serials.length; i++) {
            boolean acquired = false;
            synchronized (ewoks[serials[i]-1]) {
                while (!acquired) {
                    if (ewoks[serials[i]-1].available) {
                        ewoks[serials[i]-1].acquire();
                        acquired = true;
                    } else try {
                        ewoks[serials[i]-1].wait();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }

    /** the method release all the ewoks with the serials in the input array
     * @param serials :the serials of the ewoks used for the attack */

    public void ReleaseAll(int[] serials){
        for(int i=0; i<serials.length; i++){
            ewoks[serials[i]-1].release();
        }

    }


}
