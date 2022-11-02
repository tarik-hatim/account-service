package com.thatim.accountservice.service;

import com.thatim.accountservice.entities.Account;
import com.thatim.accountservice.exceptions.InsufficientBalanceException;
import com.thatim.accountservice.repositories.AccountRepository;
import com.thatim.accountservice.exceptions.AccountWasNotFoundException;
import com.thatim.accountservice.exceptions.service.InsufficientMinAmountException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public String transfer(int accountNumberFrom, int accountNumberTo, double amount) throws InsufficientMinAmountException
            , AccountWasNotFoundException, InsufficientBalanceException {
        if(amount < 10) throw new InsufficientMinAmountException("the amount must be 10 euros or more.");

        Account accountFrom = accountRepository.findById(accountNumberFrom)
                .orElseThrow(()-> new AccountWasNotFoundException("account is not found"));
        if((accountFrom.getBalance() - amount) < 0) throw  new InsufficientBalanceException("Insufficient balance.");
        Account accountTo = accountRepository.findById(accountNumberTo)
                .orElseThrow(() -> new AccountWasNotFoundException("account is not found"));

        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountTo.setBalance(accountTo.getBalance() + amount);

        return "Transfer was done.";
    }
}
