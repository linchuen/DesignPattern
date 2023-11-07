package org.example.StructuralPatterns.Composite.object;

import java.util.List;

public interface Company extends CompanyComponent{
    List<Department> getDepartments();
    List<Employee> getEmployees();
}
