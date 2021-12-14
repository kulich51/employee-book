package pro.sky.java.course2.employeebook.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalEmployeeException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new IllegalEmployeeException(newEmployee.getFullName() + " already exists");
        }
        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String secondName) {
        String name = firstName + " " + secondName;
        Employee toRemove;
        if ((toRemove = employees.remove(name)) == null) {
            throw new EmployeeNotFoundException(name + " Not Found");
        }
        return toRemove;
    }

    @Override
    public Employee find(String firstName, String secondName) {
        String name = firstName + " " + secondName;
        Employee toFind;
        if ((toFind = employees.get(name)) == null) {
            throw new EmployeeNotFoundException(name + " Not Found");
        }
        return toFind;
    }

    @Override
    public Collection<Employee> getEmployeesBook() {
        return employees.values();
    }
}
