package com.example.contrl7.controllers;


import com.example.contrl7.model.Transaction;
import com.example.contrl7.service.TransactionService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);



    @GetMapping("/{accountId}/history")
    public List<Transaction> getHistoryofTransaction(@PathVariable Integer accountId) {
        logger.info("Получение историй транзакции", accountId);
        return transactionService.getTransactionHistory(accountId);
    }

    @PostMapping
    public void creating(@RequestBody Transaction transaction) {
        logger.info("Создание транзакции: от счета {} на счет {} сумма {}",
                transaction.getFromAccountId(),
                transaction.getToAccountId(),
                transaction.getAmount());

        transactionService.create(transaction);
    }


}


