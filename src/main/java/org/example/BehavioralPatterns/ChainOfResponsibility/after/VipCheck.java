package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

public class VipCheck extends ActivityQualificationChain {
    @Override
    public boolean check(UserData userData) {
        if (userData.getLevel() >= 30) {
            System.out.println("符合活動資格");
            return true;
        }
        return super.check(userData);
    }
}
