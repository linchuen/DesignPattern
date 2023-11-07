package org.example.StructuralPatterns.Composite.object;

import java.util.List;

public interface Department extends CompanyComponent {
    String getName();

    void add(CompanyComponent component);

    void remove(CompanyComponent component);

    List<Employee> getEmployees();

}
