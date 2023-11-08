package org.example.BehavioralPatterns.Command.object;

import java.util.Objects;

public class ItemData {

    private final String name;
    private final int price;

    public ItemData(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemData itemData = (ItemData) o;
        return Objects.equals(name, itemData.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
