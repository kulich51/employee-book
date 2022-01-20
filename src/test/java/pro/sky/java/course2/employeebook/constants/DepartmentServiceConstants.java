package pro.sky.java.course2.employeebook.constants;

import pro.sky.java.course2.employeebook.model.Employee;

import java.util.Collection;
import java.util.List;

public final class DepartmentServiceConstants {

    public final static int INVALID_DEPARTMENT_ID = -2;
    public final static int DEFAULT_DEPARTMENT_ID = -1;
    public final static int DEPARTMENT_ID = 38;

    // Все методы DepartmentService будут тестировать для работников с DEPARTMENT_ID
    public final static Employee EMPLOYEE_WITH_MAX_SALARY =
            new Employee("Sergey", "Begunov", DEPARTMENT_ID, 500_000f);

    public final static Employee EMPLOYEE_WITH_MIN_SALARY =
            new Employee("Ruslan", "Medvedev", DEPARTMENT_ID, 95_000f);

    public final static float TOTAL_SALARY = 500_000f + 200_000f + 95_000f;
    public final static float AVERAGE_SALARY = TOTAL_SALARY / (float) 3;

    public final static Collection<Employee> ALL_EMPLOYES= List.of(
            new Employee("Dmitriy", "Maksyuk", 41, 65_000f),
            new Employee("Vladimir", "Kulikov", DEPARTMENT_ID, 200_000f),
            EMPLOYEE_WITH_MIN_SALARY,
            EMPLOYEE_WITH_MAX_SALARY,
            new Employee("Kutuzova", "Irina", 47, 99_999f)
    );

}
