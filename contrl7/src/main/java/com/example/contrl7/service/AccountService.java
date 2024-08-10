package com.example.contrl7.service;


import com.example.contrl7.model.Account;
import com.example.contrl7.repositories.AccountRepository;
import com.example.contrl7.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);



    public void updateBalance(Integer id, Double balance) {
        logger.info("обновить баланс " , balance);

        accountRepository.updateBalance(id, balance);
    }

    public void createAccount(Account account) {
        logger.info("создать акаунт" , account);
        accountRepository.save(account);
    }

    public Optional<Account> getAccount(Integer id) {
        logger.info("получить  акаунт" , id);

        return accountRepository.findById(id);
    }


}

