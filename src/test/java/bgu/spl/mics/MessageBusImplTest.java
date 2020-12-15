package bgu.spl.mics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.*;

import bgu.spl.mics.application.messages.*;
import bgu.spl.mics.application.services.*;

public class MessageBusImplTest {

    private MessageBusImpl bus;

    
    @BeforeEach
    public void setUp()
    {
        //changed from using contructor to using songelton method
        bus = MessageBusImpl.getInstance();
    }
    
    @Test
    public void testSendEvent()
    //Tests both sendEvent and subscribeEvent
    {

        MicroService m = new SampleMicroservice();
        bus.register(m);
        m.initialize();
        Event<Boolean> ev = new AttackEvent();
        Future<Boolean> future = bus.sendEvent(ev);
        assertNotNull(future);
        try 
        {
            Message msg = bus.awaitMessage(m);
            assertEquals(ev, msg);
        }
        catch (InterruptedException ex)
        {
            fail();
        }

    }

    @Test
    public void testComplete()
    {
        MicroService m = new SampleMicroservice();
        bus.register(m);
        m.initialize();
        Event<Boolean> ev = new AttackEvent();
        Future<Boolean> future = bus.sendEvent(ev);
        assertFalse(future.isDone());
        bus.complete(ev, true);
        assertTrue(future.isDone());
        assertTrue(future.get());
    }

    @Test
        //Tests both subscribeBroadcast and sendBroadcast
        void testSubscribeBroadcast () {
            MicroService m = new SampleMicroservice();
            bus.register(m);
            ExampleBroadcast brod = new ExampleBroadcast("hello");

            bus.subscribeBroadcast(ExampleBroadcast.class,m);
            bus.sendBroadcast(brod);

            try
            {
                Message msg = bus.awaitMessage(m);
                assertEquals(msg , brod);
            }
            catch (InterruptedException ex){
                fail();
            }
        }
    
}
