package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String secondName);
    Employee remove(String firstName, String secondName);
    Employee find(String firstName, String secondName);
    Collection<Employee> getEmployeesBook();
}
