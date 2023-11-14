package org.example.BehavioralPatterns.Memento.object;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Browser implements CareTaker {
    private final LinkedList<Memento> history = new LinkedList<>();
    private final int maxSavePage = 5;

    public void browseWebsite(String title, String link) {
        Page page = new Page(title, link, "sample");
        System.out.println("瀏覽" + title + "頁");
        PageRecord pageRecord = page.save();
        if (history.size() >= maxSavePage) {
            history.removeFirst();
        }
        history.add(pageRecord);
    }

    public List<Memento> getHistory() {
        List<Memento> copy = new ArrayList<>(history);
        Collections.reverse(copy);
        return copy;
    }

    @Override
    public void restore(Memento memento) {
        if (history.remove(memento)) {
            System.out.println("回到瀏覽紀錄" + ((PageRecord) memento).getTitle());
            ((PageRecord) memento).setDateTime(LocalDateTime.now());
            history.add(memento);
        } else {
            throw new NoSuchElementException();
        }
    }
}
