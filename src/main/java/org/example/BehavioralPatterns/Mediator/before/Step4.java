package org.example.BehavioralPatterns.Mediator.before;

public class Step4 {
    private final Step5 step5;

    public Step4(Step5 step5) {
        this.step5 = step5;
    }
    public void execute(){
        System.out.println("執行步驟4");
        step5.execute();
    };
}
