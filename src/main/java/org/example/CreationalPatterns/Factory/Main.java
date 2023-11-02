package org.example.CreationalPatterns.Factory;

import org.example.CreationalPatterns.Factory.after.FactoryLetterFactory;
import org.example.CreationalPatterns.Factory.object.LanguageType;
import org.example.CreationalPatterns.Factory.object.Letter;
import org.example.CreationalPatterns.Factory.object.LetterFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");

        System.out.println(new Letter("哈囉，世界!!").getMessage());
        System.out.println(new Letter("Hello world!!").getMessage());
        System.out.println();

        System.out.println("factoryLetterFactory");
        LetterFactory factoryLetterFactory = new FactoryLetterFactory();
        System.out.println(factoryLetterFactory.buildHelloLetter(LanguageType.Chinese).getMessage());
        System.out.println(factoryLetterFactory.buildHelloLetter(LanguageType.English).getMessage());
        System.out.println();
    }
}