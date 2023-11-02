package org.example.CreationalPatterns.AbstractFactory.after;

import org.example.CreationalPatterns.AbstractFactory.object.Letter;
import org.example.CreationalPatterns.AbstractFactory.object.LetterFactory;

public class ChineseLetterFactory implements LetterFactory {
    @Override
    public Letter buildHelloLetter() {
        return new Letter("哈囉，世界!!");
    }
}
