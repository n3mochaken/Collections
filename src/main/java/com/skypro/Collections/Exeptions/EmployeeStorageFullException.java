package com.skypro.Collections.Exeptions;

public class EmployeeStorageFullException extends RuntimeException{
   public EmployeeStorageFullException (String message){
        super(message);
    }
}
