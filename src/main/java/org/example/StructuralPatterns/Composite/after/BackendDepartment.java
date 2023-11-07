package org.example.StructuralPatterns.Composite.after;

import org.example.StructuralPatterns.Composite.object.CompanyComponent;
import org.example.StructuralPatterns.Composite.object.Department;
import org.example.StructuralPatterns.Composite.object.Employee;

import java.util.LinkedList;
import java.util.List;

public class BackendDepartment implements Department {
    private final int id;
    private final String name;
    private final int equipmentCost;

    public BackendDepartment(int id, String name, int equipmentCost) {
        this.id = id;
        this.name = name;
        this.equipmentCost = equipmentCost;
    }

    private final List<CompanyComponent> companyComponentList = new LinkedList<>();

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getCost() {
        return companyComponentList.stream().map(CompanyComponent::getCost).reduce(0, Integer::sum) + equipmentCost;
    }

    @Override
    public void add(CompanyComponent component) {
        companyComponentList.add(component);
    }

    @Override
    public void remove(CompanyComponent component) {
        companyComponentList.remove(component);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new LinkedList<>();
        for (CompanyComponent companyComponent : companyComponentList) {
            if (companyComponent instanceof Employee){
                employees.add((Employee) companyComponent);
            }
            if(companyComponent instanceof Department){
                employees.addAll(((Department) companyComponent).getEmployees());
            }
        }
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackendDepartment that = (BackendDepartment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
