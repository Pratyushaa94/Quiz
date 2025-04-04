package com.neha.quiz.controller;

import com.neha.quiz.dto.LoginRequest;
import com.neha.quiz.model.User;
import com.neha.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

        Map<String, Object> response = new HashMap<>();

        if (user.isPresent()) {
            if (user.get().getPassword().equals(loginRequest.getPassword())) {
                response.put("message", "Login successful");
                response.put("username", user.get().getUsername());
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Invalid username or password");
                return ResponseEntity.status(401).body(response);
            }
        } else {
            response.put("message", "User not found");
            return ResponseEntity.status(404).body(response);
        }
    }
}
