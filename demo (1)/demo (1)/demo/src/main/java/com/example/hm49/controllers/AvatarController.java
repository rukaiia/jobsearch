
package com.example.hm49.controllers;

import com.example.hm49.model.User;
import com.example.hm49.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/users")
public class AvatarController {
    @Autowired
    private UserRepository userRepository;

    private static final String UPLOAD = "uploads/";

    @PostMapping("/{id}/avatar")
    public User useAvatar(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {
        User user = (User) userRepository.findById(id).orElse(null);
        if (user != null) {
            byte[] bytes = file.getBytes();
            Path paths = Paths.get(UPLOAD + file.getOriginalFilename());
            Files.write(paths, bytes);
            user.setAvatar(paths.toString());
            userRepository.save(user);
        }
        return user;
    }
}
