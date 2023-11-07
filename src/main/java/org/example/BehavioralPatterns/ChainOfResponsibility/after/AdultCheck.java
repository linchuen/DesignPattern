package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

public class AdultCheck extends ActivityQualificationChain {
    @Override
    public boolean check(UserData userData) {
        if (userData.getAge() >= 18) {
           return super.check(userData);
        }
        System.out.println("符合活動資格");
        return false;
    }
}
