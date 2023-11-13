package org.example.BehavioralPatterns.Iterator;

import org.example.BehavioralPatterns.Iterator.after.Book;
import org.example.BehavioralPatterns.Iterator.after.BookShelf;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new Book("Clean Code", 1985));
        bookShelf.addBook(new Book("Hello World", 1979));
        bookShelf.addBook(new Book("Design Pattern", 2020));
        bookShelf.addBook(new Book("Good Code,Bad Code", 2000));

        Book book = bookShelf.findBook("Clean Code");
        System.out.println("找到書名" + book.getName() + "的書");

        System.out.println("依書名排序:");
        Iterator<Book> nameIterator = bookShelf.getNameIterator();
        while (nameIterator.hasNext()) {
            System.out.println(nameIterator.next());
        }
        System.out.println("依年份排序:");
        Iterator<Book> yearIterator = bookShelf.getYearIterator();
        while (yearIterator.hasNext()) {
            System.out.println(yearIterator.next());
        }
    }
}
