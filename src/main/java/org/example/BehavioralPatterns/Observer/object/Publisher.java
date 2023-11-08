package org.example.BehavioralPatterns.Observer.object;

public interface Publisher {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscriber(String message);
}
