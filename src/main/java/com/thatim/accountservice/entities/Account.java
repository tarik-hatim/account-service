package com.thatim.accountservice.entities;

import com.thatim.accountservice.enums.AccountType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
