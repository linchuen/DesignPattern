package org.example.BehavioralPatterns.Command.object;

public class CustomerData {
    private final int id;
    public CustomerData(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerData that = (CustomerData) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
