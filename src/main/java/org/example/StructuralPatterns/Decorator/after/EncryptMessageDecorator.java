package org.example.StructuralPatterns.Decorator.after;

import org.example.StructuralPatterns.Decorator.object.Message;

public class EncryptMessageDecorator extends MessageDecorator {
    public EncryptMessageDecorator(Message baseMessage) {
        super(baseMessage);
    }

    @Override
    public String getMessage() {
        return "這是加密後的文本\n" + super.getMessage() + "\n加密結束";
    }
}
