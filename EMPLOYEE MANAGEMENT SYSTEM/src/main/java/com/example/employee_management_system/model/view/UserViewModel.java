package com.example.employee_management_system.model.view;

import com.example.employee_management_system.model.entity.Role;

import java.util.List;

public class UserViewModel {
    private String username;
    private String password;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserViewModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
