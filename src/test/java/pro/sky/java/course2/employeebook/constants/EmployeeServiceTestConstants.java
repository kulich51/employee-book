package pro.sky.java.course2.employeebook.constants;

import pro.sky.java.course2.employeebook.model.Employee;

import java.util.Collection;
import java.util.List;

public final class EmployeeServiceTestConstants {

    public static final String VALID_FIRST_NAME_1 = "Vladimir";
    public static final String VALID_SECOND_NAME_1 = "Kulikov";
    public static final int VALID_DEPARTMENT_ID_1 = 38;
    public static final float VALID_SALARY_1 = 100_000f;

    public static final String VALID_FIRST_NAME_1_LOWER_REGISTER = "vladimir";
    public static final String VALID_FIRST_NAME_1_UPPER_REGISTER = "VLADIMIR";
    public static final String VALID_FIRST_NAME_1_MIXED_REGISTER = "vLaDiMIr";

    public static final String VALID_SECOND_NAME_1_LOWER_REGISTER = "kulikov";
    public static final String VALID_SECOND_NAME_1_UPPER_REGISTER = "KULIKOV";
    public static final String VALID_SECOND_NAME_1_MIXED_REGISTER = "kuliKOV";

    public static final String VALID_FIRST_NAME_2 = "Irina";
    public static final String VALID_SECOND_NAME_2 = "Kutuzova";
    public static final int VALID_DEPARTMENT_ID_2 = 47;
    public static final float VALID_SALARY_2 = 70_000f;

    public static final String VALID_FIRST_NAME_3 = "Ivan";
    public static final String VALID_SECOND_NAME_3 = "Nesterov";
    public static final int VALID_DEPARTMENT_ID_3 = 141;
    public static final float VALID_SALARY_3 = 150_000f;

    public static final String EMPTY_FIRST_NAME = "";
    public static final String BLANK_FIRST_NAME = " ";
    public static final String NUMERIC_FIRST_NAME = "Vlad3imir";

    public static final String EMPTY_SECOND_NAME = "";
    public static final String BLANK_SECOND_NAME = " ";
    public static final String NUMERIC_SECOND_NAME = "Kuliko5";


    public static final Employee VALID_EMPLOYEE = new Employee(
            VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1
    );

    public static final Collection<Employee> EXPECTED_COLLECTION = List.of(
            VALID_EMPLOYEE,
            new Employee(VALID_FIRST_NAME_2, VALID_SECOND_NAME_2, VALID_DEPARTMENT_ID_2, VALID_SALARY_2),
            new Employee(VALID_FIRST_NAME_3, VALID_SECOND_NAME_3, VALID_DEPARTMENT_ID_3, VALID_SALARY_3)
    );
}
