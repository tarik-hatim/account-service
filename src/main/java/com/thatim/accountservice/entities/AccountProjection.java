package com.thatim.accountservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pOne", types = Account.class)
public interface AccountProjection {
    int getAccountNumber();
    double getBalance();
}
