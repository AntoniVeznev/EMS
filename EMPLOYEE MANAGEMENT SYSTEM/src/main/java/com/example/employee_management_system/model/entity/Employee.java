package com.example.employee_management_system.model.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDay;
    private String homeAddress;
    private LocalDate hiredOn;
    private Department department;
    private Position position;
    private Location location;
    private Hours hours;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Employee setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public Employee setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        return this;
    }

    public LocalDate getHiredOn() {
        return hiredOn;
    }

    public Employee setHiredOn(LocalDate hiredOn) {
        this.hiredOn = hiredOn;
        return this;
    }
    @OneToOne
    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }
    @OneToOne
    public Hours getHours() {
        return hours;
    }

    public Employee setHours(Hours hours) {
        this.hours = hours;
        return this;
    }
    @OneToOne
    public Location getLocation() {
        return location;
    }

    public Employee setLocation(Location location) {
        this.location = location;
        return this;
    }
    @OneToOne
    public Position getPosition() {
        return position;
    }

    public Employee setPosition(Position position) {
        this.position = position;
        return this;
    }



}
