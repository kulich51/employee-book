package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.model.Employee;

import java.util.Collection;

public interface DepartmentService {
    float getTotalSalary(int departmentId);
    float getAverageSalary(int departmentId);
    Employee getEmployeeWithMaxSalary(int departmentId);
    Employee getEmployeeWithMinSalary(int departmentId);
    Collection<Employee> getEmployees(int departmentId);
}
