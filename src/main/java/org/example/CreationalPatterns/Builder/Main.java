package org.example.CreationalPatterns.Builder;

import org.example.CreationalPatterns.Builder.after.BuilderSummonService;
import org.example.CreationalPatterns.Builder.beofre.SetterSummonService;
import org.example.CreationalPatterns.Builder.object.SummonService;
import org.example.CreationalPatterns.Factory.after.FactoryLetterFactory;
import org.example.CreationalPatterns.Factory.object.LanguageType;
import org.example.CreationalPatterns.Factory.object.Letter;
import org.example.CreationalPatterns.Factory.object.LetterFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");
        SummonService setterSummonService = new SetterSummonService();
        setterSummonService.summon();
        System.out.println();

        System.out.println("after");
        SummonService builderSummonService = new BuilderSummonService();
        builderSummonService.summon();
        System.out.println();
    }
}