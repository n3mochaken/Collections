package com.skypro.Collections.controller;


import com.skypro.Collections.domain.Employee;
import com.skypro.Collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String firstName,
                                @RequestParam("surname") String secondName,
                                @RequestParam("salary") int salary,
                                @RequestParam("department") int department
    ) {
        return employeeService.addEmployee(firstName, secondName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String secondName,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("department") int department
    ) {
        return employeeService.findEmployee(firstName, secondName,salary,department);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("name") String firstName,
                                   @RequestParam("surname") String secondName,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department
    ) {
        return employeeService.deleteEmployee(firstName, secondName,salary,department);
    }

    @GetMapping("/list")
    public Collection<Employee> findAll(){return employeeService.findAll();}


}
