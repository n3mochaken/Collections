package com.skypro.Collections.service;

import com.skypro.Collections.Exeptions.EmployeeAlreadyAddedException;
import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.Exeptions.EmployeeStorageFullException;
import com.skypro.Collections.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImp implements EmployeeService {

    final int maxEmployees = 10;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(
                    "ivan", "ivanov"),

            new Employee(
                    "petr", "petrov")
    ));


    @Override
    public Employee addEmployee(String firstName, String secondName) throws EmployeeAlreadyAddedException, EmployeeStorageFullException {
        Employee employee = new Employee(firstName, secondName);


        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageFullException("NET MESTA UHODI");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("UJE DOBAVLEN");
        }
        employees.add(employee);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String name, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(name, lastName);

        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("NET TAKOGO EWE");

    }


    @Override
    public Employee findEmployee(String firstName, String secondName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("NET TAKOGO EWE");


    }


}
