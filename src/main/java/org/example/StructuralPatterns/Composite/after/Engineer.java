package org.example.StructuralPatterns.Composite.after;

import org.example.StructuralPatterns.Composite.object.Employee;

import java.util.Objects;

public class Engineer implements Employee {
    private final int id;
    private final int salary;

    public Engineer(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    @Override
    public int getCost() {
        return salary;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return id == engineer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
