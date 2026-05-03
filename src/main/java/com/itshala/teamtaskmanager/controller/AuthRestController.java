package com.itshala.teamtaskmanager.controller;

import com.itshala.teamtaskmanager.entity.User;
import com.itshala.teamtaskmanager.repository.UserRepository;
import com.itshala.teamtaskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            return "Login successful. Role: " + user.getRole();
        }

        return "Invalid email or password";
    }
}