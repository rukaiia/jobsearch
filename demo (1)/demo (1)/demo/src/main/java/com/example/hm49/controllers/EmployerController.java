package com.example.hm49.controllers;

import com.example.hm49.repositories.VacancyRepository;
import com.example.hm49.model.Vacancies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public EmployerController(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @PostMapping("/vacancies")
    public void createVacancy(@RequestBody Vacancies vacancy) throws SQLException {
        vacancyRepository.createVacancy(vacancy);
    }

    @GetMapping("/vacancies/{id}")
    public Vacancies getVacancyById(@PathVariable int id) throws SQLException {
        return vacancyRepository.getVacancyById(id);
    }

    @PutMapping("/vacancies")
    public void updateVacancy(@RequestBody Vacancies vacancy) throws SQLException {
        vacancyRepository.updateVacancy(vacancy);
    }

    @DeleteMapping("/vacancies/{id}")
    public void deleteVacancy(@PathVariable int id) throws SQLException {
        vacancyRepository.deleteVacancy(id);
    }

    @GetMapping("/vacancies")
    public List<Vacancies> getAllVacancies() throws SQLException {
        return vacancyRepository.getAllVacancies();
    }

    @GetMapping("/vacancies/category/{categoryId}")
    public List<Vacancies> getVacanciesByCategory(@PathVariable int categoryId) throws SQLException {
        return vacancyRepository.getVacanciesByCategory(categoryId);
    }
}
