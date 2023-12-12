package com.skypro.Collections.service;


public interface EmployeeService {


    void addEmployee(String firstName, String secondName);

    String deleteEmployee(String firstName, String secondName);


    String findEmployee(String firstName, String secondName);

}
