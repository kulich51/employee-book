package pro.sky.java.course2.employeebook.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFound;
import pro.sky.java.course2.employeebook.exception.IllegalEmployee;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public String add(Employee employee) {
        findDuplicate(employee);
        employees.add(employee);
        return employee.getFullName() + " added";
    }

    @Override
    public String remove(Employee employee) {
        employees.remove(getEmployeeIndex(employee));
        return employee.getFullName() + " removed";
    }

    @Override
    public Employee find(Employee employee) {
        return employees.get(getEmployeeIndex(employee));
    }

    @Override
    public Collection<Employee> getEmployeesBook() {
        return employees;
    }

    private int getEmployeeIndex(Employee employee) {
        int index = employees.indexOf(employee);
        if (index < 0) {
            throw new EmployeeNotFound(employee.getFullName() + " Not Found");
        }
        return index;
    }

    private void findDuplicate(Employee employee) {
        if (employees.contains(employee)) {
            throw new IllegalEmployee(employee.getFullName() + " already exists");
        }
    }
}
