package org.example.BehavioralPatterns.State.object;

public interface Bird {
    void move(BodyState bodyState, MoveStrategy moveStrategy);
    void eat(BodyState bodyState);
}
