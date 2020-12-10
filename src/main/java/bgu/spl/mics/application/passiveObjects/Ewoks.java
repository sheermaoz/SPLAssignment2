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
    private ConcurrentHashMap<Integer, Ewok> ewoks = new ConcurrentHashMap<>();

    private Ewoks(){

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
