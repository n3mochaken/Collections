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
    public void addEmployee(String firstName, String secondName) throws EmployeeAlreadyAddedException, EmployeeStorageFullException {
        Employee employee = new Employee(firstName, secondName);
        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageFullException("NET MESTA UHODI");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("UJE DOBAVLEN");
        }
        employees.add(employee);

    }

    @Override
    public String deleteEmployee(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("TAKOGO NET UDALAT NE BUDU");

        }
        employees.remove(employee);
        return "UDALEN" + firstName + " " + secondName;
    }

    @Override
    public String findEmployee(String firstName, String secondName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("NET TAKOGO EWE");
        }
        for (Employee employee1 : employees) {
            if (employee.equals(employee1)) {
                return " RABOTNIK " + firstName + " " + secondName + " NAIDEN";
            }
        }
        return "Opat ne nashel" + firstName + " " + secondName;
    }


}
