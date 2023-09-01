package com.example.employee_management_system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EmployeeController {

    public EmployeeController() {

    }

    @GetMapping("/employees")
    public String getDepartments(){
        return "employee";
    }

}
