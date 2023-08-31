package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Address;
import com.example.employee_management_system.model.entity.Employee;
import com.example.employee_management_system.model.entity.Location;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.repository.*;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;
    private final AddressRepository addressRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void initEmployee() {
        if (employeeRepository.count() > 0) {
            return;
        }
        addBoss();
        addModerator();
        addEmployee();
    }

    private void addEmployee() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(3L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Veliko Tarnovo")
                .setStreet("Ul. Vasil Levski N11")
                .setLocation(location);
        addressRepository.save(address);

        employee.setFullName("User Userov")
                .setEmail("user@gmail.com")
                .setBirthday(LocalDate.of(1995, 9, 9))
                .setHiredOn(LocalDate.of(2015, 6, 6))
                .setMobilePhone("0889461834")
                .setPosition(positionRepository.findById(9L).orElseThrow())
                .setDepartment(departmentRepository.findById(5L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }

    private void addModerator() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(2L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Sofia")
                .setStreet("Ul. Hristo Botev N17")
                .setLocation(location);
        addressRepository.save(address);

        employee.setFullName("Moderator Moderatorov")
                .setEmail("moderator@gmail.com")
                .setBirthday(LocalDate.of(1985, 6, 6))
                .setHiredOn(LocalDate.of(2010, 4, 4))
                .setMobilePhone("0884674523")
                .setPosition(positionRepository.findById(14L).orElseThrow())
                .setDepartment(departmentRepository.findById(7L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }

    private void addBoss() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(1L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Sofia")
                .setStreet("Bul. Evlogi and Hristo Georgievi N3")
                .setLocation(location);
        addressRepository.save(address);

        employee.setFullName("Boss Bossov")
                .setEmail("boss@gmail.com")
                .setBirthday(LocalDate.of(1975, 3, 3))
                .setHiredOn(LocalDate.of(2000, 2, 2))
                .setMobilePhone("0885458364")
                .setPosition(positionRepository.findById(1L).orElseThrow())
                .setDepartment(departmentRepository.findById(1L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }
}
