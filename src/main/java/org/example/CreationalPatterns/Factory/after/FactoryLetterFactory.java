package org.example.CreationalPatterns.Factory.after;

import org.example.CreationalPatterns.Factory.object.LanguageType;
import org.example.CreationalPatterns.Factory.object.Letter;
import org.example.CreationalPatterns.Factory.object.LetterFactory;

public class FactoryLetterFactory implements LetterFactory {
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
