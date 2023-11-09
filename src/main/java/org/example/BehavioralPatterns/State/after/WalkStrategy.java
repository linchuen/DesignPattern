package org.example.BehavioralPatterns.State.after;

import org.example.BehavioralPatterns.State.object.MoveStrategy;

public class WalkStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("使用步行移動");
    }
}
