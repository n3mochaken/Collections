package com.skypro.Collections.service;

import com.skypro.Collections.domain.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary (int departmentId);
    Employee findEmployeeWithMinSalary (int departmentId);
    Collection<Employee> findAllEmployeesByDepartment (int departmentId);
    Map<Integer, List<Employee>> findAllEmployeesSortedByDepartment (int departmentId);
}
