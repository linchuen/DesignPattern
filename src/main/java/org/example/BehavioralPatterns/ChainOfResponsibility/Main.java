package org.example.BehavioralPatterns.ChainOfResponsibility;

import org.example.BehavioralPatterns.ChainOfResponsibility.after.ChainResponsibilityActivity;
import org.example.BehavioralPatterns.ChainOfResponsibility.before.PrecursorActivity;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.Activity;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.BloodType;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        UserData user1 = new UserData(20, 30, LocalDateTime.of(2023, Month.JULY, 8, 0, 0), BloodType.A);
        UserData user2 = new UserData(20, 20, LocalDateTime.of(2023, Month.JULY, 8, 0, 0), BloodType.A);
        UserData user3 = new UserData(20, 20, LocalDateTime.of(2023, Month.JULY, 8, 0, 0), BloodType.O);

        System.out.println("before");
        Activity precursorActivity = new PrecursorActivity();
        precursorActivity.isQualified(user1);
        precursorActivity.isQualified(user2);
        precursorActivity.isQualified(user3);
        System.out.println();

        System.out.println("after");
        Activity chainResponsibilityActivity = new ChainResponsibilityActivity();
        chainResponsibilityActivity.isQualified(user1);
        chainResponsibilityActivity.isQualified(user2);
        chainResponsibilityActivity.isQualified(user3);
        System.out.println();
    }
}