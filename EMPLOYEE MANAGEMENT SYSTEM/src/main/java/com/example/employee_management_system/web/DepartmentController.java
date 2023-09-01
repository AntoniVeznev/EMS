package com.example.employee_management_system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DepartmentController {

    public DepartmentController() {

    }

    @GetMapping("/departments")
    public String getDepartments(){
        return "department";
    }

}
