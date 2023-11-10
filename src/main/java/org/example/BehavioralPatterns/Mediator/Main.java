package org.example.BehavioralPatterns.Mediator;

import org.example.BehavioralPatterns.Mediator.after.MediatorObject;
import org.example.BehavioralPatterns.Mediator.after.SingleStep1;
import org.example.BehavioralPatterns.Mediator.after.SingleStep2;
import org.example.BehavioralPatterns.Mediator.after.SingleStep3;
import org.example.BehavioralPatterns.Mediator.after.SingleStep4;
import org.example.BehavioralPatterns.Mediator.after.SingleStep5;
import org.example.BehavioralPatterns.Mediator.before.PrecursorObject;
import org.example.BehavioralPatterns.Mediator.before.Step1;
import org.example.BehavioralPatterns.Mediator.before.Step2;
import org.example.BehavioralPatterns.Mediator.before.Step3;
import org.example.BehavioralPatterns.Mediator.before.Step4;
import org.example.BehavioralPatterns.Mediator.before.Step5;
import org.example.BehavioralPatterns.Mediator.object.AnObject;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");
        Step3 step3 = new Step3();
        Step2 step2 = new Step2(step3);
        Step1 step1 = new Step1(step2);
        Step5 step5 = new Step5();
        Step4 step4 = new Step4(step5);

        AnObject precursorObject = new PrecursorObject(step1, step4);
        precursorObject.behavior();
        System.out.println();

        System.out.println("after");
        SingleStep5 s5 = new SingleStep5();
        SingleStep4 s4 = new SingleStep4();
        SingleStep3 s3 = new SingleStep3();
        SingleStep2 s2 = new SingleStep2();
        SingleStep1 s1 = new SingleStep1();
        AnObject mediatorObject = new MediatorObject(s1, s2, s3, s4, s5);
        mediatorObject.behavior();
    }
}
