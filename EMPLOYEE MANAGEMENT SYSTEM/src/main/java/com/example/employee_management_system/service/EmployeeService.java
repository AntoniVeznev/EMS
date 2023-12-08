package com.example.employee_management_system.service;

import com.example.employee_management_system.model.binding.UserRegisterBindingModel;
import com.example.employee_management_system.model.entity.Employee;
import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.model.view.EmptyEmployeeViewModel;

import java.util.List;

public interface EmployeeService {

    void initEmployee();
    List<EmployeeViewModel> allEmployees();

    void createEmptyEmploy(UserRegisterBindingModel userRegisterBindingModel);

    List<EmptyEmployeeViewModel> nullEmployees();


    EmployeeViewModel findEmployeeWithID(Long id);
}
