package com.thatim.accountservice.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private int accountNumberFrom;
    private int accountNumberTo;
    private double amount;
}
