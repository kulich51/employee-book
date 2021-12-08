package pro.sky.java.course2.employeebook.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalEmployeeException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Set<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        if (employees.add(newEmployee)) {
            return newEmployee;
        }
        throw new IllegalEmployeeException(newEmployee.getFullName() + " already exists");
    }

    @Override
    public Employee remove(String firstName, String secondName) {
        Employee toRemove = new Employee(firstName, secondName);
        if (employees.remove(toRemove)) {
            return toRemove;
        }
        throw new EmployeeNotFoundException(toRemove.getFullName() + " Not Found");
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee toFind = new Employee(firstName, secondName);
        if (employees.contains(toFind)) {
            return toFind;
        }
        throw new EmployeeNotFoundException(toFind.getFullName() + " Not Found");
    }

    @Override
    public Collection<Employee> getEmployeesBook() {
        return employees;
    }
}
