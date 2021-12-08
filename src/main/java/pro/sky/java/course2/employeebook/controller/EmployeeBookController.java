package pro.sky.java.course2.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee-book")
public class EmployeeBookController {
    private final EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    public Collection<Employee> getEmployeesBook() {
        return employeeService.getEmployeesBook();
    }
}
