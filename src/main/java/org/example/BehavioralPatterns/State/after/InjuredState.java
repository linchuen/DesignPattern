package org.example.BehavioralPatterns.State.after;

import org.example.BehavioralPatterns.State.object.BodyState;
import org.example.BehavioralPatterns.State.object.MoveStrategy;

public class InjuredState implements BodyState {

    @Override
    public void move(MoveStrategy moveStrategy) {
        System.out.println("無法正常移動");
    }

    @Override
    public void eat() {
        System.out.println("進食正常 但胃口變小了");
    }
}
