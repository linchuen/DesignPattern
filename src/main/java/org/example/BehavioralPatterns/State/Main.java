package org.example.BehavioralPatterns.State;

import org.example.BehavioralPatterns.State.after.Chicken;
import org.example.BehavioralPatterns.State.after.Eagle;
import org.example.BehavioralPatterns.State.after.FlyStrategy;
import org.example.BehavioralPatterns.State.after.HealthState;
import org.example.BehavioralPatterns.State.after.InjuredState;
import org.example.BehavioralPatterns.State.after.WalkStrategy;
import org.example.BehavioralPatterns.State.before.BirdService;
import org.example.BehavioralPatterns.State.before.BirdType;
import org.example.BehavioralPatterns.State.before.BodyType;
import org.example.BehavioralPatterns.State.before.MoveType;

public class Main {
    public static void main(String[] args) {
        System.out.println("before");
        BirdService birdService = new BirdService();
        birdService.move(BirdType.Chicken, BodyType.Health, MoveType.Fly);
        birdService.move(BirdType.Chicken, BodyType.Health, MoveType.Walk);
        birdService.eat(BirdType.Chicken, BodyType.Health);

        birdService.move(BirdType.Eagle, BodyType.Injured, MoveType.Fly);
        birdService.move(BirdType.Eagle, BodyType.Injured, MoveType.Fly);
        birdService.eat(BirdType.Eagle, BodyType.Injured);
        System.out.println();

        System.out.println("after");
        WalkStrategy walkStrategy = new WalkStrategy();
        FlyStrategy flyStrategy = new FlyStrategy();
        HealthState healthState = new HealthState();
        InjuredState injuredState = new InjuredState();

        Chicken chicken = new Chicken();
        chicken.move(healthState, flyStrategy);
        chicken.move(healthState, walkStrategy);
        chicken.eat(healthState);

        Eagle eagle = new Eagle();
        eagle.move(injuredState, flyStrategy);
        eagle.move(injuredState, walkStrategy);
        eagle.eat(injuredState);
    }
}