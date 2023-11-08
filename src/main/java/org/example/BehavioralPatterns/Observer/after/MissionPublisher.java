package org.example.BehavioralPatterns.Observer.after;

import org.example.BehavioralPatterns.Observer.object.Publisher;
import org.example.BehavioralPatterns.Observer.object.Subscriber;

import java.util.LinkedList;
import java.util.List;

public class MissionPublisher implements Publisher {
    private final List<Subscriber> subscribers = new LinkedList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.updated(message);
        }
    }
}
