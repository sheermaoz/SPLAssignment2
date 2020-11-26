package bgu.spl.mics;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgu.spl.mics.application.passiveObjects.*;

public class EwokTest {
    private Ewok ewok;

    @BeforeEach
    public void setUp()
    {
        ewok = new Ewok(1);
    }

    @Test
    public void testAquire()
    {
        assertTrue(ewok.getAvailable());
        ewok.acquire();
        assertFalse(ewok.getAvailable());
    }

    @Test
    public void testRelease()
    {
        ewok.acquire();
        assertFalse(ewok.getAvailable());
        ewok.release();
        assertTrue(ewok.getAvailable());
    }
    
}
