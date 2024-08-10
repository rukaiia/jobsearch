package com.example.contrl7.repositories;


import com.example.contrl7.model.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@AllArgsConstructor
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);



    public void save(User user) {
        logger.info("сохранение");

        jdbcTemplate.update("insert into users (phone, name, password, user_type) values (?, ?, ?, ?)",
                user.getPhone(), user.getName(), user.getPassword(), user.getUserType());
    }

    public User findByPhone(String phone) {
        logger.info("Найти по телефону");

        return jdbcTemplate.queryForObject("select * from users where phone = ?", new Object[]{phone},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setPhone(rs.getString("phone"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setUserType(rs.getString("user_type"));
                    return user;
                });
    }

    public List<User> findAll() {
        logger.info("Найти все");

        return jdbcTemplate.query("select * from users", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setPhone(rs.getString("phone"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setUserType(rs.getString("user_type"));
            return user;
        });
    }
}

