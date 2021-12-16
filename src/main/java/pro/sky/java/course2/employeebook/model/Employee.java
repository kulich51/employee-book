package pro.sky.java.course2.employeebook.model;

import java.util.Objects;

public class Employee {
    private static int employeeCount;

    private final String firstName;
    private final String secondName;
    private final Integer id;
    private Integer departmentId;
    private Float salary;

    public Employee(String firstName, String secondName, Integer departmentId, Float salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.departmentId = departmentId;
        this.salary = salary;
        this.id = ++employeeCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Float getSalary() {
        return salary;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }
}
