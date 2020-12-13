package bgu.spl.mics;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The {@link MessageBusImpl class is the implementation of the MessageBus interface.
 * Write your implementation here!
 * Only private fields and methods can be added to this class.
 */
public class MessageBusImpl implements MessageBus {
    
    private ConcurrentHashMap<MicroService,BlockingQueue<Message>> microservices = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Class<? extends Event<?>>,BlockingQueue<MicroService>> events = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Class<? extends Broadcast>,List<MicroService>> broadcasts = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Event<?>,Future> futures = new ConcurrentHashMap<>();
    
    private static class MessageBusHolder
    {
        private static MessageBusImpl instance = new MessageBusImpl();
    }

    public static MessageBusImpl getInstance()
    {
        return MessageBusHolder.instance;
    }

    
    @Override
    public <T> void subscribeEvent(Class<? extends Event<T>> type, MicroService m) {
        if (!events.contains(type))
        {
            BlockingQueue<MicroService> newQueue = new LinkedBlockingDeque<>();
            events.put(type,newQueue);
            
        }
        events.get(type).add(m);
        
    }

    @Override
    public void subscribeBroadcast(Class<? extends Broadcast> type, MicroService m) {
        if (broadcasts.contains(type))
        {
            List<MicroService> lst = new LinkedList<>();
            lst.add(m);
            
        }
        broadcasts.get(type).add(m);
        
    }

    @Override @SuppressWarnings("unchecked")
    public <T> void complete(Event<T> e, T result) {
        Future<T> future = futures.get(e);
        future.resolve(result);
    }

    @Override
    public void sendBroadcast(Broadcast b) {
        List<MicroService> toSend = broadcasts.get(b.getClass());
        for (MicroService m : toSend)
        {
            microservices.get(m).offer(b);
        }
        
    }

    
    @Override
    public <T> Future<T> sendEvent(Event<T> e) {
        
        if (!events.contains(e.getClass()))
        {
            return null;
        }
        MicroService m = events.get(e.getClass()).poll();
        if (m != null)
        {
            Future<T> future = new Future<>();
            futures.put(e, future);
            events.get(e.getClass()).offer(m);
            microservices.get(m).offer(e);
            return future;
        }

        return null;
        
    }

    @Override
    public void register(MicroService m) {
        microservices.put(m, new LinkedBlockingDeque<>());
    }

    @Override
    public void unregister(MicroService m) {
        microservices.remove(m);

        for (BlockingQueue<MicroService> microServiceQueue : events.values())
            microServiceQueue.remove(m);

        for (List<MicroService> microServiceList : broadcasts.values())
            microServiceList.remove(m);

        
    }


    @Override
    public Message awaitMessage(MicroService m) throws InterruptedException {

        return microservices.get(m).take();
    }

}
