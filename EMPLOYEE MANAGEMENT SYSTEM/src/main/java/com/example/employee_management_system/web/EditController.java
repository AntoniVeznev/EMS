package com.example.employee_management_system.web;


import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit")
public class EditController {
    private final EmployeeService employeeService;

    public EditController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public String edit(@PathVariable Long id, Model model) {
        EmployeeViewModel employeeViewModel = employeeService.findEmployeeWithID(id);
        model.addAttribute("employeeViewModel", employeeViewModel);
        return "edit-user";
    }
}