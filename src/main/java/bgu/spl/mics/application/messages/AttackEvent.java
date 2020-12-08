package bgu.spl.mics.application.messages;
import bgu.spl.mics.Event;

import java.util.LinkedList;
import java.util.List;
import bgu.spl.mics.application.passiveObjects.*;

public class AttackEvent implements Event<Boolean> {
    
    final int time;
    final List<Integer> serials;

    public AttackEvent(Attack attack)
    {
        time = attack.getDuration();
        serials = attack.getSerials();
    }

    public AttackEvent()
    {
        time = 0;
        serials = new LinkedList<>();
    }

}
