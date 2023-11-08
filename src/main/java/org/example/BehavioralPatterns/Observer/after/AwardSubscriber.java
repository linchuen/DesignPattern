package org.example.BehavioralPatterns.Observer.after;

import org.example.BehavioralPatterns.Observer.object.Subscriber;

public class AwardSubscriber implements Subscriber {
    @Override
    public void updated(String message) {
        System.out.println("發送獎勵 "+message);
    }
}
