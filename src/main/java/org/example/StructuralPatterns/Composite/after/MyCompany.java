package org.example.StructuralPatterns.Composite.after;

import org.example.StructuralPatterns.Composite.object.Company;
import org.example.StructuralPatterns.Composite.object.CompanyComponent;
import org.example.StructuralPatterns.Composite.object.Department;
import org.example.StructuralPatterns.Composite.object.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class MyCompany implements Company {
    private final List<Department> departmentList;
    public MyCompany(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    @Override
    public int getCost() {
        return departmentList.stream().map(CompanyComponent::getCost).reduce(0, Integer::sum);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentList;
    }

    @Override
    public List<Employee> getEmployees() {
        return departmentList.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toList());
    }
}
