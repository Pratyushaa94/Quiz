package com.neha.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPageController {

    @GetMapping("/")
    public ResponseEntity<Void> redirectToLogin() {
        return ResponseEntity.status(302).header("Location", "/login.html").build();
    }
}
