package org.example.CreationalPatterns.AbstractFactory.object;

public class Letter {
    public Letter(String message) {
        Message = message;
    }

    private final String Message;

    public String getMessage() {
        return Message;
    }

}
