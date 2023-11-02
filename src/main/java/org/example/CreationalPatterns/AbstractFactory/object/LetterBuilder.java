package org.example.CreationalPatterns.AbstractFactory.object;

public interface LetterBuilder {
    Letter buildHelloLetter(LanguageType languageType);
}
