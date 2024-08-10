package com.example.contrl7.controllers;



import com.example.contrl7.model.User;
import com.example.contrl7.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registration(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("Регистрация прошла успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при регистрации: " + e.getMessage());
        }
    }
}
