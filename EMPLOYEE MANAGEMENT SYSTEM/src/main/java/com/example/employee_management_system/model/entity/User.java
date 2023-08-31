package com.example.employee_management_system.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private List<Role> roles;
    private Employee employee;

    public User() {

    }

    @ManyToMany
    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @OneToOne
    public Employee getEmployee() {
        return employee;
    }

    public User setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @Column(name = "username", unique = true, nullable = false, columnDefinition = "TEXT")
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
