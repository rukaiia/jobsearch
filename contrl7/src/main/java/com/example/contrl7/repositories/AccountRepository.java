package com.example.contrl7.repositories;

import com.example.contrl7.controllers.TransactionController;
import com.example.contrl7.model.Account;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AccountRepository.class);



    public void save(Account account) {
        logger.info("сохранение");


        jdbcTemplate.update("insert into accounts (user_id, currency, balance) values (?, ?, ?)",
                account.getUserId(), account.getCurrency(), account.getBalance());
    }
    public void updateBalance(Integer id, Double balance) {
        logger.info("Обновить баланс {}", id, balance);

        jdbcTemplate.update("update accounts set balance = ? where id = ?", balance, id);
    }

    public Optional<Account> findById(Integer id) {
        logger.info("найти по id {}" , id);
        try {
            Account account = jdbcTemplate.queryForObject("select * from accounts where id = ?", new Object[]{id},
                    (rs, rowNum) -> {
                        Account acc = new Account();
                        acc.setId(rs.getInt("id"));
                        acc.setUserId(rs.getInt("user_id"));
                        acc.setCurrency(rs.getString("currency"));
                        acc.setBalance(rs.getDouble("balance"));
                        return acc;
                    });
            return Optional.ofNullable(account);
        } catch (Exception e) {
            return Optional.empty();
        }
    }




}
