package com.example.product.service;

import com.example.product.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        users.put(user.getEmail(), user);
        return "User created!";
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public boolean checkPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}
