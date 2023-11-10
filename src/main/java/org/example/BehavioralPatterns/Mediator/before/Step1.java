package org.example.BehavioralPatterns.Mediator.before;

public class Step1 {
    private final Step2 step2;

    public Step1(Step2 step2) {
        this.step2 = step2;
    }

    public void execute(){
        System.out.println("執行步驟1");
        step2.execute();
    };
}
