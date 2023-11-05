package org.example.StructuralPatterns.Decorator.after;

import org.example.StructuralPatterns.Decorator.object.Message;

public class MessageDecorator implements Message {
    private final Message baseMessage;

    public MessageDecorator(Message baseMessage) {
        this.baseMessage = baseMessage;
    }

    @Override
    public String getMessage() {
        return baseMessage.getMessage();
    }
}
