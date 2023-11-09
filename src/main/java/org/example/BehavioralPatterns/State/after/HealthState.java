package org.example.BehavioralPatterns.State.after;

import org.example.BehavioralPatterns.State.object.BodyState;
import org.example.BehavioralPatterns.State.object.MoveStrategy;

public class HealthState implements BodyState {

    @Override
    public void move(MoveStrategy moveStrategy) {
        moveStrategy.move();
    }

    @Override
    public void eat() {
        System.out.println("進食正常");
    }
}
