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
    /**
     * This function return the instance of Diary.
     * @return instance.
     */
    public static Diary getInstance()
    {
        return DiaryHolder.instance;
    }

    /**
     * This function return the number of total attacks.
     * @return total attacks.
     */
    public AtomicInteger getTotalAttack()
    {
        return totalAttacks;
    }
    
    /**
     * This function return the time in which HanSolo finished his attacks.
     * @return time in milliseconds.
     */
    public long getHanSoloFinish()
    {
        return HanSoloFinish;
    }

    /**
     * This function return the time in which C3PO finished his attacks.
     * @return time in milliseconds.
     */
    public long getC3POFinish()
    {
        return C3POFinish;
    }

    /**
     * This function return the time in which R2D2 finished his deactivation.
     * @return time in milliseconds.
     */
    public long getR2D2Deactivate()
    {
        return R2D2Deactivate;
    }

    /**
     * This function return the time in which Leia finished runnning.
     * @return time in milliseconds.
     */
    public long getLeiaTerminate()
    {
        return LeiaTerminate;
    }

    /**
     * This function return the time in which HanSolo finished runnning.
     * @return time in milliseconds.
     */
    public long getHanSoloTerminate()
    {
        return HanSoloTerminate;
    }

    /**
     * This function return the time in which C3PO finished runnning.
     * @return time in milliseconds.
     */
    public long getC3POTerminate()
    {
        return C3POTerminate;
    }

    /**
     * This function return the time in which R2D2 finished runnning.
     * @return time in milliseconds.
     */
    public long getR2D2Terminate()
    {
        return R2D2Terminate;
    }

    /**
     * This function return the time in which Lando finished runnning.
     * @return time in milliseconds.
     */
    public long getLandoTerminate()
    {
        return LandoTerminate;
    }
        
    /**
     * Increases the number of attacks completed.
     */
    public void addAttack()
    {
        totalAttacks.incrementAndGet();
    }

    /**
     * Sets HanSolo's attack finish time as time.
     * @param time: time in which HanSolo finished.
     */
    public void setHanSoloFinish(long time)
    {
        HanSoloFinish = time;
    }

    /**
     * Sets C3PO's attack finish time as time.
     * @param time: time in which C3PO finished.
     */
    public void setC3POFinish(long time)
    {
        C3POFinish = time;
    }

    /**
     * Sets R2D2's deactiovation finish time as time.
     * @param time: time in which R2D2 finished.
     */
    public void setR2D2Deactivate(long time)
    {
        R2D2Deactivate = time;
    }

    /**
     * Sets Leia's termination time as time.
     * @param time: time in which Leia terminated.
     */
    public void setLeiaTerminate(long time)
    {
        LeiaTerminate = time;
    }

    /**
     * Sets HanSolo's termination time as time.
     * @param time: time in which HanSolo terminated.
     */
    public void setHanSoloTerminate(long time)
    {
        HanSoloTerminate = time;
    }

    /**
     * Sets C3PO's termination time as time.
     * @param time: time in which C3PO terminated.
     */
    public void setC3POTerminate(long time)
    {
        C3POTerminate = time;
    }

    /**
     * Sets R2D2's termination time as time.
     * @param time: time in which R2D2 terminated.
     */
    public void setR2D2Terminate(long time)
    {
        R2D2Terminate = time;
    }

    /**
     * Sets Lando's termination time as time.
     * @param time: time in which Lando terminated.
     */
    public void setLandoTerminate(long time)
    {
        LandoTerminate = time;
    }



}
