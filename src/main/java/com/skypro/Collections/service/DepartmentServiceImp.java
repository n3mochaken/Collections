package com.skypro.Collections.service;

import com.skypro.Collections.Exeptions.EmployeeNotFoundException;
import com.skypro.Collections.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service

public class DepartmentServiceImp implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImp(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {

        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employee> findAllEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesSortedByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartmentId));
    }


}
