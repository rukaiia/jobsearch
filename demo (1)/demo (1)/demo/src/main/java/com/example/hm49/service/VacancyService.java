
package com.example.hm49.service;

import com.example.hm49.model.Vacancies;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.hm49.model.User;


import java.util.List;

@Service
public class VacancyService {

    private final JdbcTemplate jdbcTemplate;

    public VacancyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vacancies> findAllVacancies() {
        String sql = "SELECT * FROM vacancies";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Vacancies(
                rs.getInt("id"),
                rs.getInt("employer_id"),
                rs.getString("title"),
                rs.getInt("category_id"),
                rs.getDouble("salary"),
                rs.getString("description"),
                rs.getBoolean("is_active"),
                rs.getTimestamp("created_date")
        ));
    }

    public List<Vacancies> findVacanciesByCategory(int categoryId) {
        String sql = "SELECT * FROM vacancies WHERE category_id = ?";
        return jdbcTemplate.query(sql, new Object[]{categoryId}, (rs, rowNum) -> new Vacancies(
                rs.getInt("id"),
                rs.getInt("employer_id"),
                rs.getString("title"),
                rs.getInt("category_id"),
                rs.getDouble("salary"),
                rs.getString("description"),
                rs.getBoolean("is_active"),
                rs.getTimestamp("created_date")
        ));
    }

    public List<User> findApplicantsForVacancy(int vacancyId) {
        String sql = "SELECT u.* FROM users u " +
                "JOIN resumes r ON u.id = r.applicant_id " +
                "JOIN applications a ON r.id = a.resume_id " +
                "WHERE a.vacancy_id = ?";
        return jdbcTemplate.query(sql, new Object[]{vacancyId}, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("phone_number"),
                rs.getString("avatar"),
                rs.getString("account_type")
        ));
    }

}
