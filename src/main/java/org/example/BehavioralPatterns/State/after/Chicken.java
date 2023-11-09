package org.example.BehavioralPatterns.State.after;

import org.example.BehavioralPatterns.State.object.Bird;
import org.example.BehavioralPatterns.State.object.BodyState;
import org.example.BehavioralPatterns.State.object.MoveStrategy;

public class Chicken implements Bird {

    @Override
    public void move(BodyState bodyState, MoveStrategy moveStrategy) {
        System.out.print("雞 ");
        bodyState.move(moveStrategy);
    }

    @Override
    public void eat(BodyState bodyState) {
        System.out.print("雞 ");
        bodyState.eat();
    }
}
