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
@RequestMapping("/api/admin")
public class MainController {

    private final TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);



    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        logger.info("Получение все транзакции");

        return transactionService.getTransactionHistory(null);
    }
    @DeleteMapping("/transactions/{id}")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }


    @GetMapping("/transactions/approval")
    public List<Transaction> getTransactionsForApproval() {
        return transactionService.getUnapprovedTransactions();
    }

    @PostMapping("/transactions/approval")
    public void approving(@RequestBody Integer transactionId) {
        transactionService.approving(transactionId);
    }

    @PostMapping("/transactions/rollback")
    public void rollback(@RequestBody Integer transactionId) {
        transactionService.rollback(transactionId);
    }

}