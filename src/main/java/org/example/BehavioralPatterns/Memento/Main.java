package org.example.BehavioralPatterns.Memento;

import org.example.BehavioralPatterns.Memento.object.Browser;
import org.example.BehavioralPatterns.Memento.object.Memento;
import org.example.BehavioralPatterns.Memento.object.PageRecord;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.browseWebsite("Java World", "https://www.java.com");
        browser.browseWebsite("Go World", "https://www.go.com");
        browser.browseWebsite("C++ World", "https://www.c++.com");
        browser.browseWebsite("Python World", "https://www.python.com");
        browser.browseWebsite("Php World", "https://www.php.com");
        browser.browseWebsite("C World", "https://www.c.com");
        List<Memento> history = browser.getHistory();
        System.out.println("最後瀏覽依序是 " + history.stream().map(memento -> ((PageRecord) memento).getTitle()).collect(Collectors.joining("、")));

        browser.restore(history.get(2));
        List<Memento> newHistory = browser.getHistory();
        System.out.println("最後瀏覽依序是 " + newHistory.stream().map(memento -> ((PageRecord) memento).getTitle()).collect(Collectors.joining("、")));

    }
}
