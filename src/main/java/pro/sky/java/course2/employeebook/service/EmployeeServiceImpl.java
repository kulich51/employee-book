package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_COUNT = 10;
    private Employee[] employees;

    public EmployeeServiceImpl() {
        this.employees = new Employee[EMPLOYEE_COUNT];
    }

    @Override
    public String add(String firstName, String secondName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, secondName);
                return "Сотрудник " + employees[i].getFullName() + " добавлен";
            }
        }
        throw new EmployeeBookIsOverloaded();
    }

    @Override
    public String remove(String firstName, String secondName) {
        Employee toDelete = new Employee(firstName, secondName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(toDelete)) {
                employees[i] = null;
                return "Сотрудник " + toDelete.getFullName() + " удалён";
            }
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee toFind = new Employee(firstName, secondName);
        for (Employee employee : employees) {
            if (employee != null && employee.equals(toFind)) {
                return employee;
            }
        }
        throw new EmployeeNotFound();
    }
}
