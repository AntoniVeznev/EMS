package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.User;
import com.example.employee_management_system.repository.RoleRepository;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void initUsers() {

        if (userRepository.count() > 0) {
            return;
        }

        User bossUser = new User();
        User moderatorUser = new User();
        User user = new User();

        bossUser
                .setUsername("Boss")
                .setPassword("bosspassword")
                .setRole(roleRepository.findById(1L).orElseThrow());
        userRepository.save(bossUser);


        moderatorUser
                .setUsername("Moderator")
                .setPassword("moderatorpassword")
                .setRole(roleRepository.findById(2L).orElseThrow());
        userRepository.save(moderatorUser);

        user
                .setUsername("User")
                .setPassword("userpassword")
                .setRole(roleRepository.findById(3L).orElseThrow());
        userRepository.save(user);

    }
}
