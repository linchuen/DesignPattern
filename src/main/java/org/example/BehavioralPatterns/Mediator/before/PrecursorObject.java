package org.example.BehavioralPatterns.Mediator.before;

import org.example.BehavioralPatterns.Mediator.object.AnObject;

public class PrecursorObject  implements AnObject {
    private final Step1 step1;
    private final Step4 step4;

    public PrecursorObject(Step1 step1, Step4 step4) {
        this.step1 = step1;
        this.step4 = step4;
    }

    @Override
    public void behavior() {
        step1.execute();
        step4.execute();
    }
}
