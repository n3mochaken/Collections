package com.skypro.Collections.controller;

import com.skypro.Collections.domain.Employee;
import com.skypro.Collections.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max")
    public Employee checkMax(@RequestParam("id") int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min")
    public Employee checkMin(@RequestParam("id") int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/sortDep")
    public Collection<Employee> sortDep(@RequestParam("id") int departmentId) {
        return departmentService.findAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/sortAll")
    public Map<Integer, List<Employee>> sortAll(@RequestParam("id") int departmentId) {
        return departmentService.findAllEmployeesSortedByDepartment(departmentId);
    }


}
