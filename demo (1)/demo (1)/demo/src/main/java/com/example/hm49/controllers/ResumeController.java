
package com.example.hm49.controllers;

import com.example.hm49.model.Resumes;
import com.example.hm49.service.ResumeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/search/category")
    public List<Resumes> findResumesByCategory(@RequestParam int categoryId) {
        return resumeService.findResumesByCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    public List<Resumes> findResumesByUserId(@PathVariable int userId) {
        return resumeService.findResumesByUserId(userId);
    }
}
