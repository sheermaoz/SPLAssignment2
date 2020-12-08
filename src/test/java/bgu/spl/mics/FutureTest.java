package bgu.spl.mics;

import org.junit.jupiter.api.BeforeEach;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


public class FutureTest {

    private Future<String> future;

    @BeforeEach
    public void setUp(){
        future = new Future<>();
    }

    @Test
    public void testResolve(){
        String str = "someResult";
        future.resolve(str);
        assertTrue(future.isDone());
        assertTrue(str.equals(future.get()));
    }

    @Test
    public void testGet() {
        LocalTime now = LocalTime.now();
        assertTrue((future.get(2, TimeUnit.SECONDS)) == null);
        assertTrue(LocalTime.now().compareTo(now.plusSeconds(2)) != -1);
        String str = "someResult";
        future.resolve(str);
        assertFalse((future.get(2, TimeUnit.SECONDS)) == null);
    }
}
