package org.example.BehavioralPatterns.Mediator.after;


import org.example.BehavioralPatterns.Mediator.object.AnObject;

public class MediatorObject implements AnObject {
    private final SingleStep1 singleStep1;
    private final SingleStep2 singleStep2;
    private final SingleStep3 step3;
    private final SingleStep4 singleStep4;
    private final SingleStep5 singleStep5;

    public MediatorObject(SingleStep1 singleStep1, SingleStep2 singleStep2, SingleStep3 step3, SingleStep4 singleStep4, SingleStep5 singleStep5) {
        this.singleStep1 = singleStep1;
        this.singleStep2 = singleStep2;
        this.step3 = step3;
        this.singleStep4 = singleStep4;
        this.singleStep5 = singleStep5;
    }

    @Override
    public void behavior() {
        singleStep1.execute();
        singleStep2.execute();
        step3.execute();
        singleStep4.execute();
        singleStep5.execute();
    }
}
