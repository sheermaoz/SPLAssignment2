package bgu.spl.mics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

import bgu.spl.mics.application.messages.AttackEvent;
import bgu.spl.mics.application.services.*;

public class MessageBusImplTest extends MessageBusImpl {
    private MessageBusImpl bus;

    
    @BeforeEach
    public void setUp()
    {
        bus = new MessageBusImpl();
    }
    
    @Test
    public void testSendEvent()
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
            System.out.println("Got Exception: " + ex);
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
    
}
