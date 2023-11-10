package org.example.BehavioralPatterns.Mediator.before;

public class Step2 {
    private final Step3 step3;

    public Step2(Step3 step3) {
        this.step3 = step3;
    }
    public void execute(){
        System.out.println("執行步驟2");
        step3.execute();
    };
}
