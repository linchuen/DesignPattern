package org.example.CreationalPatterns.Factory.object;

public interface LetterFactory {
    Letter buildHelloLetter(LanguageType languageType);
}
