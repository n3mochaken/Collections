package com.skypro.Collections.controller;


import com.skypro.Collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("name") String firstName,
                              @RequestParam("surname") String secondName
    ) {

        employeeService.addEmployee(firstName, secondName);
        return "employeeAdded";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("name") String firstName,
                               @RequestParam("surname") String secondName
    ) {
        return employeeService.findEmployee(firstName, secondName);
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String secondName
    ) {
        return employeeService.deleteEmployee(firstName, secondName);
    }


}
