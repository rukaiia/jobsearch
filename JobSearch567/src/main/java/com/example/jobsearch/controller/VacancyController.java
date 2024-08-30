package com.example.jobsearch.controller;

import com.example.jobsearch.dto.vacancy.InputVacancyDto;
import com.example.jobsearch.service.CategoryService;
import com.example.jobsearch.service.ProfileService;
import com.example.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final CategoryService categoryService;
    private final ProfileService profileService;


    @PostMapping("vacancy/add")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String createVacancy(InputVacancyDto vacancyDto,
                                Model model) {
        vacancyService.createVacancy(vacancyDto);
        profileService.getProfile(model);
        return "employer/createVacancyTemplate";
    }
}
