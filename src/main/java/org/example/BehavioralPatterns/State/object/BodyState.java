package org.example.BehavioralPatterns.State.object;

public interface BodyState {
    void move(MoveStrategy moveStrategy);

    void eat();
}
