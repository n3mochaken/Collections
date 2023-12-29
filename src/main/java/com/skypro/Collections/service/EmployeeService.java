package com.skypro.Collections.service;


import com.skypro.Collections.Exeptions.EmployeeAlreadyAddedException;
import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.Exeptions.EmployeeStorageFullException;
import com.skypro.Collections.domain.Employee;

import java.util.Collection;
import java.util.Collections;

public interface EmployeeService {


    Employee addEmployee(String firstName, String secondName, int salary, int department) throws EmployeeStorageFullException, EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String secondName , int salary, int department) throws EmployeeNotFoundException;


    Employee findEmployee(String firstName, String secondName, int salary, int department) throws EmployeeNotFoundException;

    Collection<Employee> findAll();
}
