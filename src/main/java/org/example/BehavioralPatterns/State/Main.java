package org.example.BehavioralPatterns.State;

import org.example.BehavioralPatterns.State.after.Chicken;
import org.example.BehavioralPatterns.State.after.Eagle;
import org.example.BehavioralPatterns.State.after.FlyStrategy;
import org.example.BehavioralPatterns.State.after.HealthState;
import org.example.BehavioralPatterns.State.after.InjuredState;
import org.example.BehavioralPatterns.State.after.WalkStrategy;

public class Main {
    public static void main(String[] args) {
        WalkStrategy walkStrategy = new WalkStrategy();
        FlyStrategy flyStrategy = new FlyStrategy();
        HealthState healthState = new HealthState();
        InjuredState injuredState = new InjuredState();

        Chicken chicken = new Chicken();
        chicken.eat(healthState);
        chicken.move(healthState, walkStrategy);

        Eagle eagle = new Eagle();
        eagle.eat(injuredState);
        eagle.move(injuredState, flyStrategy);
    }
}