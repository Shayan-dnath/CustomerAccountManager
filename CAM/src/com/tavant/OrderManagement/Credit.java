package com.tavant.OrderManagement;
import java.util.*;
public class Credit extends Payment {

    private String cardNumber;
    private String expirationDate;

    public Credit(float amount, String cardNumber, String expirationDate) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public boolean authentication() {
        // Credit card authentication logic
        return true; // Placeholder for logic
    }
}