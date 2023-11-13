package org.example.BehavioralPatterns.Iterator.after;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameIterator implements Iterator<Book> {
    private final List<Book> bookList;
    private int index = -1;

    public NameIterator(Map<String, Book> bookMap) {
        this.bookList = bookMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size() - 1;
    }

    @Override
    public Book next() {
        index++;
        return bookList.get(index);
    }
}
