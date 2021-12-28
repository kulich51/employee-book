package pro.sky.java.course2.employeebook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/total-salary/{departmentId}")
    public Float getTotalSalary(@PathVariable int departmentId) {
        return departmentService.getTotalSalary(departmentId);
    }

    @GetMapping("/average-salary/{departmentId}")
    public Float getAverageSalary(@PathVariable int departmentId) {
        return departmentService.getAverageSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> getEmployees(@RequestParam (required = false, defaultValue = "-1") int departmentId) {
        return departmentService.getEmployees(departmentId);
    }
}
