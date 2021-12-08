package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

import java.awt.*;
import java.util.Collection;

public interface EmployeeService {
    String add(Employee employee);
    String remove(Employee employee);
    Employee find(Employee employee);
    Collection<Employee> getEmployeesBook();
}
