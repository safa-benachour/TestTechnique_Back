package com.example.product.controlleur;

import com.example.product.domain.JwtUtil;
import com.example.product.domain.User;
import com.example.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenController {
    @Autowired
    private UserService userService;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/account")
    public String create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/token")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        User user = userService.getUser(req.get("email"));
        if (user != null && userService.checkPassword(req.get("password"), user.getPassword())) {
            return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
