package com.tavant.OrderManagement;
import java.util.*;
public class Check extends Payment {

    private String  bankId;
    private String checkNumber;

    public Check(float amount, String bankId, String checkNumber) {
        super(amount);
        this.bankId = bankId;
        this.checkNumber = checkNumber;
    }

    public String getBankId() {
        return bankId;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public boolean authentication() {
        // Credit card authentication logic
        return true; // Placeholder for logic
    }
}