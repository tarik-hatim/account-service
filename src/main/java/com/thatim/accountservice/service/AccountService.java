package com.thatim.accountservice.service;

import com.thatim.accountservice.exceptions.AccountWasNotFoundException;
import com.thatim.accountservice.exceptions.InsufficientBalanceException;
import com.thatim.accountservice.exceptions.service.InsufficientMinAmountException;

public interface AccountService {
    String transfer(int accountNumberFrom, int accountNumberTo, double amount) throws InsufficientMinAmountException, AccountWasNotFoundException, InsufficientBalanceException;
}
