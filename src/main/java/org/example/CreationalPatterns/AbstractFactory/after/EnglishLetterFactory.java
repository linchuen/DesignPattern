package org.example.CreationalPatterns.AbstractFactory.after;

import org.example.CreationalPatterns.AbstractFactory.object.Letter;
import org.example.CreationalPatterns.AbstractFactory.object.LetterFactory;

public class EnglishLetterFactory implements LetterFactory {
    @Override
    public Letter buildHelloLetter() {
        return new Letter("Hello world!!");
    }
}
