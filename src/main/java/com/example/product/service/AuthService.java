package com.example.product.service;

import com.example.product.domain.JwtUtil;
import com.example.product.domain.User;
import com.example.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructeur où nous créons directement une instance de BCryptPasswordEncoder
    public AuthService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password); // Encoder le mot de passe avec BCrypt
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword); // Comparer les mots de passe
    }
}
