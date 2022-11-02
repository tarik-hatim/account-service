package com.thatim.accountservice.exceptions.service;

public class InsufficientMinAmountException extends Exception {
    public InsufficientMinAmountException(String message) {
        super(message);
    }
}
