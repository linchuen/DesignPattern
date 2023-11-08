package org.example.BehavioralPatterns.Observer.after;

import org.example.BehavioralPatterns.Observer.object.Publisher;

public class Mission {
    private final Publisher publisher;

    public Mission(Publisher publisher) {
        this.publisher = publisher;
    }

    public void complete(){
        System.out.println("完成任務");
        publisher.notifySubscriber("這是完成任務通知");
    }
}
