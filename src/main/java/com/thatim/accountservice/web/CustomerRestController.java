package com.thatim.accountservice.web;

import com.thatim.accountservice.entities.Account;
import com.thatim.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class CustomerRestController {

    private AccountRepository accountRepository;

    public CustomerRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts/{code}")
    public Account getAccount(@PathVariable Integer code) {
        return accountRepository.findById(code).get();
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {

        return accountRepository.save(account);
    }
    @PutMapping("/accounts/{code}")
    public Account updateAccount(@PathVariable Integer code, @RequestBody Account account) {
        account.setAccountNumber(code);
        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts/{code}")
    public void deleteAccount(@PathVariable Integer code) {
        accountRepository.deleteById(code);
    }
}
