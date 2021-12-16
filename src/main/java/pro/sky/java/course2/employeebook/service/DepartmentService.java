package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

import java.util.Collection;

public interface DepartmentService {
    float getTotalSalary(Integer departmentId);
    float getAverageSalary(Integer departmentId);
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Collection<Employee> getEmployees(Integer departmentId);
}
