package com.example.hm49.DAO;

import com.example.hm49.model.Vacancies;

import java.util.List;

public interface VacancyDAO {
    Vacancies findById(int id);
    List<Vacancies> findByEmployerId(int employerId);
    void create(Vacancies vacancy);
    void update(Vacancies vacancy);
    void delete(int id);
}

