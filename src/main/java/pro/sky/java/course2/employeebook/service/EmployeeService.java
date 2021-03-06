package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

import java.awt.*;
import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String secondName, Integer departmentId, Float salary);
    Employee remove(String firstName, String secondName);
    Employee find(String firstName, String secondName);
    Collection<Employee> getEmployeesBook();
}
