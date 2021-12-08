package pro.sky.java.course2.employeebook.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalEmployeeException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<Employee, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        if (employees.containsKey(newEmployee)) {
            throw new IllegalEmployeeException(newEmployee.getFullName() + " already exists");
        }
        employees.put(newEmployee, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String secondName) {
        Employee toRemove = new Employee(firstName, secondName);
        if (employees.remove(toRemove, toRemove)) {
            return toRemove;
        }
        throw new EmployeeNotFoundException(toRemove.getFullName() + " Not Found");
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee toFind = new Employee(firstName, secondName);
        if (employees.containsKey(toFind)) {
            return employees.get(toFind);
        }
        throw new EmployeeNotFoundException(toFind.getFullName() + " Not Found");
    }

    @Override
    public Collection<Employee> getEmployeesBook() {
        return employees.values();
    }
}
