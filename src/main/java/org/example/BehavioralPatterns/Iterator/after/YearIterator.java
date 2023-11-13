package org.example.BehavioralPatterns.Iterator.after;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YearIterator implements Iterator<Book> {
    private final List<Book> bookList;
    private int index = -1;

    public YearIterator(Map<String, Book> bookMap) {
        this.bookList = bookMap.values().stream()
                .sorted(Comparator.comparing(Book::getYear))
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
