package org.example.CreationalPatterns.AbstractFactory;

import org.example.CreationalPatterns.AbstractFactory.after.FactoryLetterBuilder;
import org.example.CreationalPatterns.AbstractFactory.before.PrecursorLetterBuilder;
import org.example.CreationalPatterns.AbstractFactory.object.LanguageType;
import org.example.CreationalPatterns.AbstractFactory.object.LetterBuilder;

public class Main {

    public static void main(String[] args) {
        System.out.println("precursorLetterBuilder");
        LetterBuilder precursorLetterBuilder = new PrecursorLetterBuilder();
        System.out.println(precursorLetterBuilder.buildHelloLetter(LanguageType.Chinese).getMessage());
        System.out.println(precursorLetterBuilder.buildHelloLetter(LanguageType.English).getMessage());
        System.out.println();

        System.out.println("factoryLetterBuilder");
        LetterBuilder factoryLetterBuilder = new FactoryLetterBuilder();
        System.out.println(factoryLetterBuilder.buildHelloLetter(LanguageType.Chinese).getMessage());
        System.out.println(factoryLetterBuilder.buildHelloLetter(LanguageType.English).getMessage());
        System.out.println();
    }
}