package com.yogurt.service.impl;

import com.yogurt.dto.UserDto;
import com.yogurt.entity.user.Role;
import com.yogurt.entity.user.User;
import com.yogurt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(Role.ROLE_ADMIN);
        userRepository.save(newUser);
    }
}
