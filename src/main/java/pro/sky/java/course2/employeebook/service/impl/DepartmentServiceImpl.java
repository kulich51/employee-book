package pro.sky.java.course2.employeebook.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.DepartmentService;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final int DEFAULT_DEPARTMENT = -1;

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public float getTotalSalary(int departmentId) {
        return filterByDepartment(departmentId).
                map(Employee::getSalary).
                reduce(0.0F, Float::sum);
    }

    @Override
    public float getAverageSalary(int departmentId) {
        long count = filterByDepartment(departmentId).count();
        return getTotalSalary(departmentId) / (float) count;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return filterByDepartment(departmentId).
                max(Comparator.comparing(Employee::getSalary)).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return filterByDepartment(departmentId).
                min(Comparator.comparing(Employee::getSalary)).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Collection<Employee> getEmployees(int departmentId) {
        return filterByDepartment(departmentId).
                sorted(Comparator.comparing(Employee::getFullName)).
                collect(Collectors.toList());
    }


    private Stream<Employee> filterByDepartment(int departmentId) {
        return employeeService.
                getEmployeesBook().
                stream().
                filter(employee -> employee.getDepartmentId().equals(departmentId) || departmentId == DEFAULT_DEPARTMENT);
    }
}
