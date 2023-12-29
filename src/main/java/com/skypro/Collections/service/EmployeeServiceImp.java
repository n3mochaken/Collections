package com.skypro.Collections.service;

import com.skypro.Collections.Exeptions.EmployeeAlreadyAddedException;
import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.Exeptions.EmployeeStorageFullException;
import com.skypro.Collections.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImp implements EmployeeService {


    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "ivan ivanov",
            new Employee(
                    "ivan", "ivanov", 1000, 1),
            "petr petrov",
            new Employee(
                    "petr", "petrov", 1000, 2),
            "dima dimin",
            new Employee("dima", "dimin", 1500, 3),
            "nikita nikitin",
            new Employee("nikita", "nikitin", 2000, 1)

    ));


    @Override
    public Employee addEmployee(String firstName, String secondName, int salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageFullException {
        Employee employee = new Employee(firstName, secondName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("TAKOY EST");
        }
        employees.put(employee.getFullName(), employee);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String secondName, int salary, int department) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName, salary, department);
        if (employees.containsValue(employee.getFullName())) {
            employees.remove(employee.getFullName());
        }
        return employee;

    }


    @Override
    public Employee findEmployee(String firstName, String secondName, int salary, int department) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, secondName, salary, department);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("NET TAKOGO EWE");
        }
        return employee;


    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection((employees.values()));
    }


}
