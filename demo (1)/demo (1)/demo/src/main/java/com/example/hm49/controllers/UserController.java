
package com.example.hm49.controllers;

import com.example.hm49.model.User;
import com.example.hm49.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/search")
    public List<User> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email) {
        if (name != null && phoneNumber != null && email != null) {
            return userService.findUsersByNamePhoneEmail(name, phoneNumber, email);
        } else if (name != null) {
            return userService.findUsersByName(name);
        } else if (phoneNumber != null) {
            return userService.findUsersByPhoneNumber(phoneNumber);
        } else if (email != null) {
            return userService.findUsersByEmail(email);
        } else {
            return userService.findAllUsers();
        }
    }
}
