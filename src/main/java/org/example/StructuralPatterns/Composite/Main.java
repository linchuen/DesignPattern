package org.example.StructuralPatterns.Composite;

import org.example.StructuralPatterns.Composite.after.BackendDepartment;
import org.example.StructuralPatterns.Composite.after.Engineer;
import org.example.StructuralPatterns.Composite.after.MyCompany;
import org.example.StructuralPatterns.Composite.object.Company;
import org.example.StructuralPatterns.Composite.object.Department;
import org.example.StructuralPatterns.Composite.object.Employee;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new SecureRandom();

        BackendDepartment javaDepartment = new BackendDepartment(random.nextInt(), "Java Team", 120_0000);
        BackendDepartment goDepartment = new BackendDepartment(random.nextInt(), "Go Team", 100_0000);
        BackendDepartment cDepartment = new BackendDepartment(random.nextInt(), "C Team", 150_0000);

        Engineer java1 = new Engineer(random.nextInt(1000), 8_0000);
        Engineer java2 = new Engineer(random.nextInt(1000), 6_0000);
        Engineer java3 = new Engineer(random.nextInt(1000), 4_0000);
        javaDepartment.add(java1);
        javaDepartment.add(java2);
        javaDepartment.add(java3);

        Engineer go1 = new Engineer(random.nextInt(1000), 7_0000);
        Engineer go2 = new Engineer(random.nextInt(1000), 7_0000);
        Engineer go3 = new Engineer(random.nextInt(1000), 7_0000);
        goDepartment.add(go1);
        goDepartment.add(go2);
        goDepartment.add(go3);

        Engineer c1 = new Engineer(random.nextInt(1000), 10_0000);
        Engineer c2 = new Engineer(random.nextInt(1000), 6_0000);
        cDepartment.add(c1);
        cDepartment.add(c2);

        Company company = new MyCompany(List.of(javaDepartment, goDepartment, cDepartment));
        System.out.println("公司總開銷:" + company.getCost());
        System.out.println("公司部門");
        for (Department department : company.getDepartments()) {
            System.out.printf("%10s 開銷:%10d%n", department.getName(), department.getCost());
        }
        for (Employee employee : company.getEmployees()) {
            System.out.printf("員編:%05d 薪資:%10d%n", employee.getId(), employee.getSalary());
        }
    }
}
