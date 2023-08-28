package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Employee;
import com.example.employee_management_system.repository.*;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;
    private final PositionRepository positionRepository;
    private final HoursRepository hoursRepository;
    private final RoleRepository roleRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository, PositionRepository positionRepository, HoursRepository hoursRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        this.positionRepository = positionRepository;
        this.hoursRepository = hoursRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void initEmployees() {
        if (employeeRepository.count() > 0) {
            return;
        }


        Employee employee = new Employee();
        employee
                .setBirthDay(LocalDate.of(1989, 6, 16))
                .setEmail("kaligula_1989@cnn.com")
                .setHiredOn(LocalDate.of(2023, 8, 28))
                .setHomeAddress("bul. Evlogi and Hristo Georgievi")
                .setName("Antoni Veznev")
                .setPhone("0889481045")
                .setDepartment(departmentRepository.findById(5L).orElseThrow())
                .setHours(hoursRepository.findById(1L).orElseThrow())
                .setLocation(locationRepository.findById(3L).orElseThrow())
                .setPosition(positionRepository.findById(11L).orElseThrow())
                .setRole(roleRepository.findById(3L).orElseThrow());

        employeeRepository.save(employee);

    }
}
