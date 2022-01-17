package pro.sky.java.course2.employeebook.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalEmployeeException;
import pro.sky.java.course2.employeebook.exception.InvalidEmployeeNameException;
import pro.sky.java.course2.employeebook.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements pro.sky.java.course2.employeebook.service.EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String secondName, Integer department, Float salary) {
        Employee newEmployee = createNewEmployee(firstName, secondName, department, salary);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new IllegalEmployeeException(newEmployee.getFullName() + " already exists");
        }
        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    private Employee createNewEmployee(String firstName, String secondName, Integer department, Float salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(secondName)) {
            firstName = StringUtils.capitalize(firstName.toLowerCase());
            secondName = StringUtils.capitalize(secondName.toLowerCase());
            return new Employee(firstName, secondName, department, salary);
        }
        throw new InvalidEmployeeNameException();
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
