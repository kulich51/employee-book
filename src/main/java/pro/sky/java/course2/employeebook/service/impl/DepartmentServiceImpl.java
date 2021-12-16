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

    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public float getTotalSalary(Integer departmentId) {
        return filterByDepartment(departmentId).
                map(Employee::getSalary).
                reduce(0.0F, Float::sum);
    }

    @Override
    public float getAverageSalary(Integer departmentId) {
        long count = filterByDepartment(departmentId).count();
        return getTotalSalary(departmentId) / (float) count;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return filterByDepartment(departmentId).
                max(getComparatorBySalary()).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return filterByDepartment(departmentId).
                min(getComparatorBySalary()).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    private Comparator<Employee> getComparatorBySalary() {
        return Comparator.comparing(Employee::getSalary);
    }

    @Override
    public Collection<Employee> getEmployees(Integer departmentId) {
        return filterByDepartment(departmentId).
                sorted(getComparatorByFullName()).
                collect(Collectors.toList());
    }

    private Comparator<Employee> getComparatorByFullName() {
        return Comparator.comparing(Employee::getFullName);
    }

    private Stream<Employee> filterByDepartment(Integer departmentId) {
        return employeeService.
                getEmployeesBook().
                stream().
                filter(employee -> departmentId != null ? employee.getDepartmentId().equals(departmentId) : true);
    }
}
