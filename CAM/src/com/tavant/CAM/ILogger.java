package com.tavant.CAM;

public interface ILogger {
    void logTransaction(int account, String action, double amount);
    // Add other logging methods if needed
    void logAccountCreation();
}