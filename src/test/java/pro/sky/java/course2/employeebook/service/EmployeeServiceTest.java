package pro.sky.java.course2.employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalEmployeeException;
import pro.sky.java.course2.employeebook.exception.InvalidEmployeeNameException;
import pro.sky.java.course2.employeebook.model.Employee;
import pro.sky.java.course2.employeebook.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pro.sky.java.course2.employeebook.constants.EmployeeServiceTestConstants.*;

public class EmployeeServiceTest {

    private EmployeeServiceImpl out;

    @BeforeEach
    void init() {
        out = new EmployeeServiceImpl();
    }

    static Stream<Arguments> differentLetterSizeProvider() {
        return Stream.of(
                arguments(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1_LOWER_REGISTER, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1_UPPER_REGISTER, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1_MIXED_REGISTER, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1_LOWER_REGISTER, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1_UPPER_REGISTER, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1_MIXED_REGISTER, VALID_DEPARTMENT_ID_1, VALID_SALARY_1)
                );
    }

    @ParameterizedTest
    @MethodSource("differentLetterSizeProvider")
    void addValidEmployee(String firstName, String secondName, int departmentId, float salary) {
        assertEquals(
                VALID_EMPLOYEE,
                out.add(firstName, secondName, departmentId, salary)
        );
    }

    static Stream<Arguments> invalidEmployeeNameProvider() {
        return Stream.of(
                arguments(EMPTY_FIRST_NAME, VALID_FIRST_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(BLANK_FIRST_NAME, VALID_FIRST_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(NUMERIC_FIRST_NAME, VALID_FIRST_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, EMPTY_SECOND_NAME, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, BLANK_SECOND_NAME, VALID_DEPARTMENT_ID_1, VALID_SALARY_1),
                arguments(VALID_FIRST_NAME_1, NUMERIC_SECOND_NAME, VALID_DEPARTMENT_ID_1, VALID_SALARY_1)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmployeeNameProvider")
    void throwInvalidEmployeeNameExceptionWhenEmployeeNameInvalid(String firstName, String secondName, int departmentId, float salary) {
        assertThrows(InvalidEmployeeNameException.class, () -> out.add(firstName, secondName, departmentId, salary));
    }



    @Test
    void throwIllegalEmployeeExceptionWhenDuplicateEmployee() {
        out.add(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1);
        assertThrows(
                IllegalEmployeeException.class,
                () -> out.add(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1)
        );
    }

    @Test
    void removeEmployee() {
        out.add(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1);
        assertEquals(VALID_EMPLOYEE, out.remove(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1));
    }

    @Test
    void throwEmployeeNotFoundExceptionWhenUnknownEmployeeRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1));
    }

    @Test
    void findEmployee() {
        out.add(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1);
        assertEquals(VALID_EMPLOYEE, out.find(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1));
    }

    @Test
    void throwEmployeeNotFoundExceptionWhenUnknownEmployeeFind() {
        out.add(VALID_FIRST_NAME_1, VALID_SECOND_NAME_1, VALID_DEPARTMENT_ID_1, VALID_SALARY_1);
        out.add(VALID_FIRST_NAME_2, VALID_SECOND_NAME_2, VALID_DEPARTMENT_ID_2, VALID_SALARY_2);
        out.add(VALID_FIRST_NAME_3, VALID_SECOND_NAME_3, VALID_DEPARTMENT_ID_3, VALID_SALARY_3);

        Collection<Employee> actual = out.getEmployeesBook();

        assertTrue(
            EXPECTED_COLLECTION.size() == actual.size() && EXPECTED_COLLECTION.containsAll(actual) && actual.containsAll(EXPECTED_COLLECTION)
        );
    }




}
