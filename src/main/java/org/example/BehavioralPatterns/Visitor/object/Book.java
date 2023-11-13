package org.example.BehavioralPatterns.Visitor.object;

public class Book {
    private final String name;
    private final int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
