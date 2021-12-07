package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

public interface EmployeeService {
    String add(String firstName, String secondName);
    String remove(String firstName, String secondName);
    Employee find(String firstName, String secondName);
}
