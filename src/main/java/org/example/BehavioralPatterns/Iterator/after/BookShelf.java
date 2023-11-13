package org.example.BehavioralPatterns.Iterator.after;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookShelf {
    private final Map<String, Book> nameBookMap = new HashMap<>();

    public void addBook(Book book) {
        nameBookMap.put(book.getName(), book);
    }

    public Book findBook(String name) {
        return nameBookMap.get(name);
    }

    public Iterator<Book> getNameIterator() {
        return new NameIterator(this.nameBookMap);
    }

    public Iterator<Book> getYearIterator() {
        return new YearIterator(this.nameBookMap);
    }
}
