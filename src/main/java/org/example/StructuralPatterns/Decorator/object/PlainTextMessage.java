package org.example.StructuralPatterns.Decorator.object;

import org.example.StructuralPatterns.Decorator.object.Message;

public class PlainTextMessage implements Message {
    @Override
    public String getMessage() {
        return "這是一個文本";
    }
}
