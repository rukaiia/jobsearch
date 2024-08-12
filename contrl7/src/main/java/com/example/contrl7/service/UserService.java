package com.example.contrl7.service;


import com.example.contrl7.model.User;
import com.example.contrl7.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void register(User user) {
        logger.info("регистрацияz" , user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}

