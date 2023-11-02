package org.example.CreationalPatterns.AbstractFactory.after;

import org.example.CreationalPatterns.AbstractFactory.object.LanguageType;
import org.example.CreationalPatterns.AbstractFactory.object.Letter;
import org.example.CreationalPatterns.AbstractFactory.object.LetterBuilder;
import org.example.CreationalPatterns.AbstractFactory.object.LetterFactory;

import java.util.HashMap;
import java.util.Map;

public class FactoryLetterBuilder implements LetterBuilder {
    private final Map<LanguageType, LetterFactory> letterFactoryMap;

    public FactoryLetterBuilder() {
        letterFactoryMap = new HashMap<>();
        letterFactoryMap.put(LanguageType.Chinese, new ChineseLetterFactory());
        letterFactoryMap.put(LanguageType.English, new EnglishLetterFactory());
    }

    @Override
    public Letter buildHelloLetter(LanguageType languageType) {
        LetterFactory letterFactory=letterFactoryMap .get(languageType);
        return letterFactory.buildHelloLetter();
    }
}
