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
    private Ewok[] ewoks;

    private Ewoks(){
        ewoks = new Ewok[0];
    }
    private Ewoks(int num){
        ewoks = new Ewok[num];
        for (int i = 0; i < num; i++)
        {
            ewoks[i] = new Ewok(i+1);
        }
    }

    public static Ewoks getInstance(int num)
    {
        if (instance == null)
        {
            instance = new Ewoks(num);
        }
        return instance;
    }

    public static Ewoks getInstance()
    {
        if (instance == null)
        {
            instance = new Ewoks();
        }
        return instance;
    }
}
