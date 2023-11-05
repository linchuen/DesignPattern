package org.example.StructuralPatterns.Decorator.after;

import org.example.StructuralPatterns.Decorator.object.Message;

public class FooterMessageDecorator extends MessageDecorator {
    public FooterMessageDecorator(Message baseMessage) {
        super(baseMessage);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " 加上尾部文字";
    }
}
