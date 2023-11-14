package org.example.BehavioralPatterns.Memento.object;

import java.time.LocalDateTime;
import java.util.Objects;

public class PageRecord implements Memento {
    private final String title;
    private final String link;
    private LocalDateTime dateTime;
    public PageRecord(String title, String link, LocalDateTime dateTime) {
        this.title = title;
        this.link = link;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageRecord that = (PageRecord) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
