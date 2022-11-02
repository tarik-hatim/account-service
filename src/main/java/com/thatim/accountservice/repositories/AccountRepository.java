package com.thatim.accountservice.repositories;

import com.thatim.accountservice.entities.Account;
import com.thatim.accountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @RestResource(path = "byType")
    List<Account> findByAccountType(AccountType type);
}
