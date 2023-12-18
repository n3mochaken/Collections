package com.skypro.Collections.service;

import com.skypro.Collections.Exeptions.EmployeeAlreadyAddedException;
import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.Exeptions.EmployeeStorageFullException;
import com.skypro.Collections.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class EmployeeServiceImp implements EmployeeService {


    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "ivan ivanov",
            new Employee(
                    "ivan", "ivanov"),
            "petr petrov",
            new Employee(
                    "petr", "petrov")
    ));


    @Override
    public Employee addEmployee(String firstName, String secondName) throws EmployeeAlreadyAddedException, EmployeeStorageFullException {
        Employee employee = new Employee(firstName, secondName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("TAKOY EST");
        }
        employees.put(employee.getFullName(), employee);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String secondName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName);
        if (employees.containsValue(employee.getFullName())) {
            employees.remove(employee.getFullName(), employee);
        }
        return employee;

    }


    @Override
    public Employee findEmployee(String firstName, String secondName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("NET TAKOGO EWE");
        }
        return employee;


    }


}
