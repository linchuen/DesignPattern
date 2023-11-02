package org.example.CreationalPatterns.AbstractFactory.before;

import org.example.CreationalPatterns.AbstractFactory.object.LanguageType;
import org.example.CreationalPatterns.AbstractFactory.object.Letter;
import org.example.CreationalPatterns.AbstractFactory.object.LetterBuilder;

public class PrecursorLetterBuilder implements LetterBuilder {
    @Override
    public Letter buildHelloLetter(LanguageType languageType) {
        if (languageType == LanguageType.Chinese) {
            return new Letter("哈囉，世界!!");
        } else if (languageType == LanguageType.English) {
            return new Letter("Hello world!!");
        }
        return null;
    }
}
