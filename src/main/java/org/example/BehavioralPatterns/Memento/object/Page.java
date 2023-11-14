package org.example.BehavioralPatterns.Memento.object;

import java.time.LocalDateTime;

public class Page implements Originator {
    private final String title;
    private final String link;
    private final String html;

    public Page(String title, String link, String html) {
        this.title = title;
        this.link = link;
        this.html = html;
    }

    @Override
    public PageRecord save() {
        return new PageRecord(this.title, this.link,  LocalDateTime.now());
    }
}
