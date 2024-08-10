
package com.example.hm49.controllers;


import com.example.hm49.model.User;
import com.example.hm49.model.Vacancies;
import com.example.hm49.service.VacancyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/all")
    public List<Vacancies> findAllVacancies() {
        return vacancyService.findAllVacancies();
    }

    @GetMapping("/search/category")
    public List<Vacancies> findVacanciesByCategory(@RequestParam int categoryId) {
        return vacancyService.findVacanciesByCategory(categoryId);
    }

    @GetMapping("/applicants")
    public List<User> findApplicantsForVacancy(@RequestParam int vacancyId) {
        return vacancyService.findApplicantsForVacancy(vacancyId);
    }
}
