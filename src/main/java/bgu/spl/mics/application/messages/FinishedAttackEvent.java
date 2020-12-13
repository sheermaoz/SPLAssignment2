package bgu.spl.mics.application.messages;

import bgu.spl.mics.Event;

/**
 *  once a microservice finishes an attack, it will send this event */
public class FinishedAttackEvent implements Event<Boolean> {

    public FinishedAttackEvent(){}
}
