
package com.example.hm49.service;

import com.example.hm49.model.User;
import com.example.hm49.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findUsersByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public List<User> findUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findUsersByNamePhoneEmail(String name, String phoneNumber, String email) {
        return userRepository.findByNamePhoneEmail(name, phoneNumber, email);
    }


}
