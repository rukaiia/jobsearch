package com.example.contrl7.repositories;

import com.example.contrl7.model.Transaction;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Repository
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TransactionRepository.class);



    public void save(Transaction transaction) {
        logger.info("сохранение");

        jdbcTemplate.update("insert into O transactions (from_account_id, to_account_id, amount, currency, timestamp, status, rollback, rollback_date) values (?, ?, ?, ?, ?, ?, ?, ?)",
                transaction.getFromAccountId(), transaction.getToAccountId(), transaction.getAmount(), transaction.getCurrency(), transaction.getTimestamp(), transaction.getStatus(), transaction.isRollback(), transaction.getRollbackDate());
    }
    public Optional<Transaction> findById(Integer id) {
        logger.info("найти по tId {}" , id);

        return jdbcTemplate.query("select * from transactions where id = ?", new Object[]{id},
                (rs, rowNum) -> {
                    Transaction transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setFromAccountId(rs.getInt("from_account_id"));
                    transaction.setToAccountId(rs.getInt("to_account_id"));
                    transaction.setAmount(rs.getDouble("amount"));
                    transaction.setCurrency(rs.getString("currency"));
                    transaction.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                    transaction.setStatus(rs.getString("status"));
                    transaction.setRollback(rs.getBoolean("rollback"));
                    transaction.setRollbackDate(rs.getTimestamp("rollback_date") != null ? rs.getTimestamp("rollback_date").toLocalDateTime() : null);
                    return transaction;
                }).stream().findFirst();
    }

    public List<Transaction> findByAccountId(Integer accountId) {
        logger.info("найти по accountId {}" , accountId);
        return jdbcTemplate.query("select * from transactions where from_account_id = ? or to_account_id = ?", new Object[]{accountId, accountId},
                (rs, rowNum) -> {
                    Transaction transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setFromAccountId(rs.getInt("from_account_id"));
                    transaction.setToAccountId(rs.getInt("to_account_id"));
                    transaction.setAmount(rs.getDouble("amount"));
                    transaction.setCurrency(rs.getString("currency"));
                    transaction.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                    transaction.setStatus(rs.getString("status"));
                    transaction.setRollback(rs.getBoolean("rollback"));
                    transaction.setRollbackDate(rs.getTimestamp("rollback_date") != null ? rs.getTimestamp("rollback_date").toLocalDateTime() : null);
                    return transaction;
                });
    }
    public List<Transaction> findByStatus(String status) {
        logger.info("найти по статусу {}" , status);

        return jdbcTemplate.query("select * from transactions where status = ?", new Object[]{status},
                (rs, rowNum) -> {
                    Transaction transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setFromAccountId(rs.getInt("from_account_id"));
                    transaction.setToAccountId(rs.getInt("to_account_id"));
                    transaction.setAmount(rs.getDouble("amount"));
                    transaction.setCurrency(rs.getString("currency"));
                    transaction.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
                    transaction.setStatus(rs.getString("status"));
                    transaction.setRollback(rs.getBoolean("rollback"));
                    transaction.setRollbackDate(rs.getTimestamp("rollback_date") != null ? rs.getTimestamp("rollback_date").toLocalDateTime() : null);
                    return transaction;
                });
    }



    public void delete(Integer id) {
        logger.info("удалить по accountId {}" , id);

        jdbcTemplate.update("delete from transactions where id = ?", id);
    }


}
