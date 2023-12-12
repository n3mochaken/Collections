package com.skypro.Collections.domain;

import java.util.Objects;

public class Employee {

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    private String firstName;
    private String secondName;


    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;

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

