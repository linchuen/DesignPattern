package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.BloodType;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

public class BloodOCheck extends ActivityQualificationChain{
    @Override
    public boolean check(UserData userData) {
        if (BloodType.O.equals(userData.getBloodType())) {
           return super.check(userData);
        }
        System.out.println("不符合活動資格");
        return false;
    }
}
