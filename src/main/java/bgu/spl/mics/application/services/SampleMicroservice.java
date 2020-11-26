package bgu.spl.mics.application.services;


import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.messages.AttackEvent;

public class SampleMicroservice extends MicroService {
    
    public SampleMicroservice()
    {
        super("test");
    }
    
    
    @Override
    protected void initialize() {
        subscribeEvent(AttackEvent.class, (AttackEvent i) -> {System.out.println("df");});
        
    }

    
}
