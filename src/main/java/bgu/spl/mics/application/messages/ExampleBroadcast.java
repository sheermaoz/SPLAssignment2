package bgu.spl.mics.application.messages;
import bgu.spl.mics.Broadcast;


public class ExampleBroadcast implements Broadcast {

    private String exBrod;

    public ExampleBroadcast(String senderId) {
        this.exBrod = senderId;
    }
}
