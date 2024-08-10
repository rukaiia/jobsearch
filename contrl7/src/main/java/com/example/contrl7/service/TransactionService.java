package com.example.contrl7.service;

import com.example.contrl7.model.Account;
import com.example.contrl7.model.Transaction;
import com.example.contrl7.repositories.AccountRepository;
import com.example.contrl7.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public void create(Transaction transaction) {
        logger.info("Создание транзакции: {}", transaction);

        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("PENDING");
        transaction.setRollback(false);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory(Integer accountId) {
        logger.info("Получение истории транзакций для аккаунта ID: {}", accountId);

        return transactionRepository.findByAccountId(accountId);
    }

    public List<Transaction> getUnapprovedTransactions() {
        logger.info("Получение неодобренных транзакций");

        return transactionRepository.findByStatus("PENDING");
    }

    public void approving(Integer transactionId) {
        logger.info("Одобрение транзакции ID: {}", transactionId);
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Транзакция не найдена"));

        if ("PENDING".equals(transaction.getStatus())) {
            transaction.setStatus("APPROVED");
            transactionRepository.save(transaction);

            updateBalances(transaction);
        } else {
            throw new RuntimeException("Транзакция не находится в статусе ожидания одобрения");
        }
    }

    private void updateBalances(Transaction transaction) {
        logger.info("Обновление баланса аккаунтов для транзакции: {}", transaction);

        Account acc = accountRepository.findById(transaction.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("Аккаунт отправителя не найден"));
        acc.setBalance(acc.getBalance() - transaction.getAmount());

        Account toAccount = accountRepository.findById(transaction.getToAccountId())
                .orElseThrow(() -> new RuntimeException("Аккаунт получателя не найден"));
        toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());

        accountRepository.save(acc);
        accountRepository.save(toAccount);
    }



    private void rollbackAccountBalances(Transaction transaction) {
        Account accn = accountRepository.findById(transaction.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("Аккаунт отправителя не найден"));
        accn.setBalance(accn.getBalance() + transaction.getAmount());

        Account toAccount = accountRepository.findById(transaction.getToAccountId())
                .orElseThrow(() -> new RuntimeException("Аккаунт получателя не найден"));
        toAccount.setBalance(toAccount.getBalance() - transaction.getAmount());

        accountRepository.save(accn);
        accountRepository.save(toAccount);
    }

    public void delete(Integer id) {
        logger.info("Удаление транзакции ID: {}", id);

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Транзакция не найдена"));

        if ("ROLLED_BACK".equals(transaction.getStatus())) {
            transactionRepository.delete(id);
        } else {
            throw new RuntimeException("Транзакция должна быть откатана перед удалением");
        }

    }
    public void rollback(Integer transactionId) {
        Transaction trn = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Транзакция не найдена"));

        if ("APPROVED".equals(trn.getStatus())) {
            rollbackAccountBalances(trn);

            trn.setStatus("ROLLED_BACK");
            trn.setRollback(true);
            trn.setRollbackDate(LocalDateTime.now());
            transactionRepository.save(trn);
        } else {
            throw new RuntimeException("Невозможно откатить не одобренную транзакцию");
        }
    }
}
