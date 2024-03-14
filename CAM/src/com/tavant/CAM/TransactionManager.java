package com.tavant.CAM;

import java.sql.*;
import java.util.logging.Logger;
import java.util.*;

class TransactionManager{
    private Map<String, Logger> accountLoggerMap;
    static double balance = 0.0;



    public static void deposit(int accountNumber, double depositAmount) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Create a prepared statement to update the balance
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE Bank_Ac SET Balance = Balance + ? WHERE Account_No = ?");

            // Set parameters for deposit amount and account number
            pstmt.setDouble(1, depositAmount);
            pstmt.setInt(2, accountNumber);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {


                System.out.println("Deposit of Rs." + depositAmount + " made successfully.");
            } else {
                System.out.println("Failed to make deposit.");
            }

            // Close the statement
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    //Display Balance
    public static void displaybalance(int accountNumber, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Create a prepared statement
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT Balance FROM Bank_Ac WHERE Account_No = ? AND Password = ?");

            // Set the account number and password as parameters
            pstmt.setInt(1, accountNumber);
            pstmt.setString(2, password);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if the result set has any rows
            if (rs.next()) {
                // Retrieve the balance from the result set
                balance = rs.getDouble("Balance");
                System.out.println("Balance for account number " + accountNumber + " is: " + balance);
            } else {
                System.out.println("Account number and password combination not found.");
            }

            // Close the result set and statement
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    // Withdraw method
    public static void withdraw(int accountNumber, double withdrawalAmount) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Create a prepared statement to update the balance
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE Bank_Ac SET Balance = Balance - ? WHERE Account_No = ? AND Balance >= ?");

            // Set parameters for withdrawal amount, account number, and ensure the balance is sufficient
            pstmt.setDouble(1, withdrawalAmount);
            pstmt.setInt(2, accountNumber);
            pstmt.setDouble(3, withdrawalAmount);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Withdrawal of Rs." + withdrawalAmount + " made successfully.");
            } else {
                System.out.println("Insufficient balance or failed to make withdrawal.");
            }

            // Close the statement
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static boolean Authentication(int accountNumber, String enteredPassword) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Create a prepared statement
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT Balance FROM Bank_Ac WHERE Account_No = ? AND Password = ?");

            // Set the account number and password as parameters
            pstmt.setInt(1, accountNumber);
            pstmt.setString(2, enteredPassword);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if the result set has any rows
            if (rs.next()) {
                // Retrieve the balance from the result set
                return true;
            } else {
                System.out.println("Account number and password combination not found.");
            }

            // Close the result set and statement
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }
}


