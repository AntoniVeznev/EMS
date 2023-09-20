package com.example.employee_management_system.service;

import com.example.employee_management_system.model.view.EmployeeViewModel;

import java.util.List;

public interface EmployeeService {

    void initEmployee();
    List<EmployeeViewModel> allEmployees();
}
