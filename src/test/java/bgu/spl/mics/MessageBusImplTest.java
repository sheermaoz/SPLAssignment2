package bgu.spl.mics;

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
    public void testSubscribe()
    {

        MicroService m = new SampleMicroservice();
        bus.register(m);
        m.initialize();
        bus.sendEvent(new AttackEvent());
        try 
        {
            Message msg = bus.awaitMessage(m);
            assertTrue(msg != null);
        }
        catch (InterruptedException ex)
        {
            System.out.println("Got Exception: " + ex);
            fail();
        }

    }
    
}
