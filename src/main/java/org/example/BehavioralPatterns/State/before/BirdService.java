package org.example.BehavioralPatterns.State.before;

public class BirdService {

    public void move(BirdType birdType, BodyType bodyType, MoveType moveType) {
        if (birdType == BirdType.Eagle) {
            System.out.print("老鷹 ");
            if (bodyType == BodyType.Injured) {
                System.out.println("無法正常移動");
            } else if (bodyType == BodyType.Health) {
                if (moveType == MoveType.Fly) {
                    System.out.println("使用飛行移動");
                } else if (moveType == MoveType.Walk) {
                    System.out.println("使用步行移動");
                }
            }
        } else if (birdType == BirdType.Chicken) {
            System.out.print("雞 ");
            if (bodyType == BodyType.Injured) {
                System.out.println("無法正常移動");
            } else if (bodyType == BodyType.Health) {
                if (moveType == MoveType.Fly) {
                    System.out.println("拍動翅膀 但甚麼事都沒發生");
                } else if (moveType == MoveType.Walk) {
                    System.out.println("使用步行移動");
                }
            }
        }
    }

    public void eat(BirdType birdType, BodyType bodyType) {
        if (birdType == BirdType.Eagle) {
            System.out.print("老鷹 ");
            if (bodyType == BodyType.Injured) {
                System.out.println("進食正常 但胃口變小了");
            } else if (bodyType == BodyType.Health) {
                System.out.println("進食正常");
            }
        } else if (birdType == BirdType.Chicken) {
            System.out.print("雞 ");
            if (bodyType == BodyType.Injured) {
                System.out.println("進食正常 但胃口變小了");
            } else if (bodyType == BodyType.Health) {
                System.out.println("進食正常");
            }
        }
    }
}
