package com.skypro.Collections.domain;

public class Employee {

    private String fullName;
    private String firstName;
    private String secondName;


    public Employee(String firstName, String secondName) {
        this.fullName = firstName + secondName;

    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName;
    }
}

