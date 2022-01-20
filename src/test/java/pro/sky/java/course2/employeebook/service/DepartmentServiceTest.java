package pro.sky.java.course2.employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.impl.DepartmentServiceImpl;
import pro.sky.java.course2.employeebook.service.impl.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.employeebook.constants.DepartmentServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    private DepartmentServiceImpl out;

    @BeforeEach
    void init() {
        out = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.getEmployeesBook()).thenReturn(ALL_EMPLOYES);
    }

    @Test
    void totalSalary() {
        assertEquals(TOTAL_SALARY, out.getTotalSalary(DEPARTMENT_ID));
    }

    @Test
    void averageSalary() {
        assertEquals(AVERAGE_SALARY, out.getAverageSalary(DEPARTMENT_ID));
    }

    @Test
    void getEmployeeWithMaxSalary() {
        assertEquals(EMPLOYEE_WITH_MAX_SALARY, out.getEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void getEmployeeWithMinSalary() {
        assertEquals(EMPLOYEE_WITH_MIN_SALARY, out.getEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    void throwEmployeeNotFoundExceptionWhenDepartmentIdInvalid() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMaxSalary(INVALID_DEPARTMENT_ID));
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMinSalary(INVALID_DEPARTMENT_ID));
    }

    @Test
    void getAllEmployeesFilteredByDepartment() {
        Collection<Employee> expected = ALL_EMPLOYES
                .stream().
                filter(employee -> employee.getDepartmentId().equals(DEPARTMENT_ID))
                .sorted(Comparator.comparing(Employee::getFullName))
                .collect(Collectors.toList());

        assertEquals(expected, out.getEmployees(DEPARTMENT_ID));
    }

    @Test
    void getAllEmployeesWhenDepartmentIdNotPassed() {
        List<Employee> expected = new ArrayList<>(ALL_EMPLOYES);
        expected.sort(Comparator.comparing(Employee::getFullName));

        assertEquals(expected, out.getEmployees(DEFAULT_DEPARTMENT_ID));
    }
}
