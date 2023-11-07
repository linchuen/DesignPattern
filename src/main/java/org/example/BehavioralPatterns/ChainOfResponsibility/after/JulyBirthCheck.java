package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

import java.time.Month;

public class JulyBirthCheck extends ActivityQualificationChain {
    @Override
    public boolean check(UserData userData) {
        if (Month.JULY.equals(userData.getBirthday().getMonth())) {
           return super.check(userData);
        }
        System.out.println("不符合活動資格");
        return false;
    }
}
