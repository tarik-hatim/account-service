package com.thatim.accountservice;

import com.thatim.accountservice.entities.Account;
import com.thatim.accountservice.enums.AccountType;
import com.thatim.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner start(AccountRepository accountRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Account.class);
            Account account1 = new Account();
            account1.setAccountType(AccountType.CURRENT);
            account1.setBalance(53000);
            account1.setCreatedAt(new Date());
            accountRepository.save(account1);
            Account account2 = new Account();
            account2.setAccountType(AccountType.CURRENT);
            account2.setBalance(32000);
            account2.setCreatedAt(new Date());
            accountRepository.save(account2);
            Account account3 = new Account();
            account3.setAccountType(AccountType.SAVING);
            account3.setBalance(54000);
            account3.setCreatedAt(new Date());
            accountRepository.save(account3);
        };
    }
}
