package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.Activity;
import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

public class ChainResponsibilityActivity implements Activity {
    private final ActivityQualificationChain firstCheck;

    public ChainResponsibilityActivity() {
        JulyBirthCheck julyBirthCheck = new JulyBirthCheck();
        VipCheck vipCheck = new VipCheck();
        AdultCheck adultCheck = new AdultCheck();
        BloodOCheck bloodOCheck = new BloodOCheck();
        firstCheck = julyBirthCheck;
        firstCheck.next(vipCheck)
                .next(adultCheck)
                .next(bloodOCheck);
    }

    @Override
    public boolean isQualified(UserData userData) {
        return firstCheck.check(userData);
    }
}
