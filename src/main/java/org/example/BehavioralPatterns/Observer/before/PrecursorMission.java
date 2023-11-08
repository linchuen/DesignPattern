package org.example.BehavioralPatterns.Observer.before;

public class PrecursorMission {

    public void complete(){
        System.out.println("完成任務");
        System.out.println("發送Email " + "這是完成任務通知");
        System.out.println("發送獎勵 "+"這是完成任務通知");
    }
}
