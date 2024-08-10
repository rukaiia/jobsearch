

package com.example.hm49.repositories;

import com.example.hm49.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, rs -> {
            if (rs.next()) {
                return Optional.of(mapRowToUser(rs, 1));
            } else {
                return Optional.empty();
            }
        });
    }


    public User save(User user) {
        if (user.getId() == 0) {
            String sql = "INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getAge(), user.getEmail(), user.getPassword(), user.getPhoneNumber(), user.getAvatar(), user.getAccountType());
            String idSql = "SELECT LAST_INSERT_ID()";
            int newId = jdbcTemplate.queryForObject(idSql, Integer.class);
            user.setId(newId);
            return user;
        } else {
            String sql = "UPDATE users SET name = ?, surname = ?, age = ?, email = ?, password = ?, phone_number = ?, avatar = ?, account_type = ? WHERE id = ?";
            jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getAge(), user.getEmail(), user.getPassword(), user.getPhoneNumber(), user.getAvatar(), user.getAccountType(), user.getId());
            return user;
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, this::mapRowToUser);
    }

    public List<User> findByName(String name) {
        String sql = "SELECT * FROM users WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, this::mapRowToUser);
    }

    public List<User> findByPhoneNumber(String phoneNumber) {
        String sql = "SELECT * FROM users WHERE phone_number = ?";
        return jdbcTemplate.query(sql, new Object[]{phoneNumber}, this::mapRowToUser);
    }

    public List<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, this::mapRowToUser);
    }

    public List<User> findByNamePhoneEmail(String name, String phoneNumber, String email) {
        String sql = "SELECT * FROM users WHERE name = ? AND phone_number = ? AND email = ?";
        return jdbcTemplate.query(sql, new Object[]{name, phoneNumber, email}, this::mapRowToUser);
    }

    public List<User> findApplicantsForVacancy(int vacancyId) {
        String sql = "SELECT u.* FROM users u " +
                "JOIN resumes r ON u.id = r.applicant_id " +
                "JOIN applications a ON r.id = a.resume_id " +
                "WHERE a.vacancy_id = ?";
        return jdbcTemplate.query(sql, new Object[]{vacancyId}, this::mapRowToUser);
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAvatar(rs.getString("avatar"));
        user.setAccountType(rs.getString("account_type"));
        return user;
    }
}
