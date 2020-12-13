package bgu.spl.mics.application.passiveObjects;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Passive data-object representing a Diary - in which the flow of the battle is recorded.
 * We are going to compare your recordings with the expected recordings, and make sure that your output makes sense.
 * <p>
 * Do not add to this class nothing but a single constructor, getters and setters.
 */
public class Diary {
    private AtomicInteger totalAttacks;
    private long HanSoloFinish;
    private long C3POFinish;
    private long R2D2Deactivate;
    private long LeiaTerminate;
    private long HanSoloTerminate;
    private long C3POTerminate;
    private long R2D2Terminate;
    private long LandoTerminate;   
    
    private static class DiaryHolder
    {
        private static Diary instance = new Diary();
    }
    
    private Diary()
    {
        totalAttacks = new AtomicInteger();
    }
    
    public static Diary getInstance()
    {
        return DiaryHolder.instance;
    }

    public AtomicInteger getTotalAttack()
    {
        return totalAttacks;
    }
    
    public long getHanSoloFinish()
    {
        return HanSoloFinish;
    }

    public long getC3POFinish()
    {
        return C3POFinish;
    }

    public long getR2D2Deactivate()
    {
        return R2D2Deactivate;
    }

    public long getLeiaTerminate()
    {
        return LeiaTerminate;
    }

    public long getHanSoloTerminate()
    {
        return HanSoloTerminate;
    }

    public long getC3POTerminate()
    {
        return C3POTerminate;
    }

    public long getR2D2Terminate()
    {
        return R2D2Terminate;
    }

    public long getLandoTerminate()
    {
        return LandoTerminate;
    }
        
    public void addAttack()
    {
        totalAttacks.incrementAndGet();
    }

    public void setHanSoloFinish(long time)
    {
        HanSoloFinish = time;
    }

    public void setC3POFinish(long time)
    {
        C3POFinish = time;
    }

    public void setR2D2Deactivate(long time)
    {
        R2D2Deactivate = time;
    }

    public void setLeiaTerminate(long time)
    {
        LeiaTerminate = time;
    }

    public void setHanSoloTerminate(long time)
    {
        HanSoloTerminate = time;
    }

    public void setC3POTerminate(long time)
    {
        C3POTerminate = time;
    }

    public void setR2D2Terminate(long time)
    {
        R2D2Terminate = time;
    }

    public void setLandoTerminate(long time)
    {
        LandoTerminate = time;
    }



}
