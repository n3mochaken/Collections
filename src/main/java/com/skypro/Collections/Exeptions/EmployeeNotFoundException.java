package com.skypro.Collections.Exeptions;

import com.skypro.Collections.service.EmployeeService;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }

}

