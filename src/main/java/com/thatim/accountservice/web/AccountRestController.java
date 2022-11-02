package com.thatim.accountservice.web;

import com.thatim.accountservice.dtos.TransferRequestDTO;
import com.thatim.accountservice.exceptions.AccountWasNotFoundException;
import com.thatim.accountservice.exceptions.InsufficientBalanceException;
import com.thatim.accountservice.exceptions.service.InsufficientMinAmountException;
import com.thatim.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/accounts/transfer")
    public String transfer(@RequestBody TransferRequestDTO requestDTO) throws InsufficientMinAmountException, AccountWasNotFoundException, InsufficientBalanceException {
        return accountService.transfer(requestDTO.getAccountNumberFrom(),requestDTO.getAccountNumberTo(),requestDTO.getAmount());
    }
}
