package com.skypro.Collections.domain;

import java.util.Objects;

public class Employee {

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    private String firstName;
    private String secondName;
    private int departmentId;
    private int salary;



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;


    public Employee(String firstName, String secondName, int salary, int department) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fullName = firstName + " " + secondName;
        this.salary = salary;
        this.departmentId = department;

    }


    @Override
    public String toString() {
        return "ФИО: " + firstName + " " + secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName());
    }
}

