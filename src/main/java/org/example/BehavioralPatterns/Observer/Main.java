package org.example.BehavioralPatterns.Observer;

import org.example.BehavioralPatterns.Observer.after.AwardSubscriber;
import org.example.BehavioralPatterns.Observer.after.EmailSubscriber;
import org.example.BehavioralPatterns.Observer.after.Mission;
import org.example.BehavioralPatterns.Observer.after.MissionPublisher;
import org.example.BehavioralPatterns.Observer.before.PrecursorMission;

public class Main {
    public static void main(String[] args) {
        System.out.println("before");
        PrecursorMission precursorMission = new PrecursorMission();
        precursorMission.complete();
        System.out.println();

        System.out.println("after");
        AwardSubscriber awardSubscriber = new AwardSubscriber();
        EmailSubscriber emailSubscriber = new EmailSubscriber();
        MissionPublisher missionPublisher = new MissionPublisher();
        missionPublisher.subscribe(awardSubscriber);
        missionPublisher.subscribe(emailSubscriber);
        Mission mission = new Mission(missionPublisher);
        mission.complete();
        System.out.println();
    }
}