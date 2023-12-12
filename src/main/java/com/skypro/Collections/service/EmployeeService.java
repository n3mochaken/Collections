package com.skypro.Collections.service;


import com.skypro.Collections.Exeptions.EmployeeAlreadyAddedException;
import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.Exeptions.EmployeeStorageFullException;
import com.skypro.Collections.domain.Employee;

public interface EmployeeService {


    Employee addEmployee(String firstName, String secondName)throws EmployeeStorageFullException, EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String secondName)throws EmployeeNotFoundException;


    Employee findEmployee(String firstName, String secondName)throws EmployeeNotFoundException;

}
