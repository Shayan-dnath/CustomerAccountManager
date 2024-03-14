package com.tavant.CAM;

import java.util.logging.Logger;

public class FileLogger {

    private static Logger logger;

    public static void logTransaction(int account, String action, double amount) {
        logger.info(action + " of $" + amount + " for account: " + account);
    }

    public void logAccountCreation(){
        logger.info("Account is created");
    }

    // Implement other logging methods if needed
}

