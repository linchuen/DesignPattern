package org.example.BehavioralPatterns.ChainOfResponsibility.after;

import org.example.BehavioralPatterns.ChainOfResponsibility.object.UserData;

public abstract class ActivityQualificationChain {
    private ActivityQualificationChain chain;

    public boolean check(UserData userData) {
        if (chain == null) {
            System.out.println("符合活動資格");
            return true;
        }

        return chain.check(userData);
    }

    public ActivityQualificationChain next(ActivityQualificationChain chain) {
        this.chain = chain;
        return chain;
    }
}
