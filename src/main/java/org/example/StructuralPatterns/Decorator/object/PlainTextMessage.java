package org.example.StructuralPatterns.Decorator.object;

public class PlainTextMessage implements Message {
    @Override
    public String getMessage() {
        return "這是一個文本";
    }
}
