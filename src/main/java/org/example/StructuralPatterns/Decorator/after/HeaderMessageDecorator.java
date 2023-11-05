package org.example.StructuralPatterns.Decorator.after;

import org.example.StructuralPatterns.Decorator.object.Message;

public class HeaderMessageDecorator extends MessageDecorator {
    public HeaderMessageDecorator(Message baseMessage) {
        super(baseMessage);
    }

    @Override
    public String getMessage() {
        return "加上頭部部文字 " + super.getMessage();
    }
}
