package org.example.BehavioralPatterns.ChainOfResponsibility.before;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.Activity;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.BloodType;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

import java.time.Month;

public class PrecursorActivity implements Activity {
    @Override
    public boolean isQualified(UserData userData) {
        //userData.getLevel() >= 30 && Month.JANUARY.equals(userData.getBirthday().getMonth()) ||
        //userData.getAge() >= 18 && BloodType.O.equals(userData.getBloodType()) && Month.JANUARY.equals(userData.getBirthday().getMonth())
        if ((userData.getLevel() >= 30 || userData.getAge() >= 18 && BloodType.O.equals(userData.getBloodType())) && Month.JULY.equals(userData.getBirthday().getMonth())) {
            System.out.println("符合活動資格");
            return true;
        }
        System.out.println("不符合活動資格");
        return false;
    }
}
