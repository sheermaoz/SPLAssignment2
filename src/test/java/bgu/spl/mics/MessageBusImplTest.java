package bgu.spl.mics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import bgu.spl.mics.application.services.*;

public class MessageBusImplTest extends MessageBusImpl {
    private MessageBusImpl bus;

    
    @BeforeEach
    public void setUp()
    {
        bus = new MessageBusImpl();
    }
    
    @Test
    public void testRegister()
    {

        MicroService m = new HanSoloMicroservice();
        bus.register(m);
        //assertTrue(bus.getSize() == 1);

    }
    
}
