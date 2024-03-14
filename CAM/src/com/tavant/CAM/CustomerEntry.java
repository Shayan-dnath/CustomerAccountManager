package com.tavant.CAM;
import java.sql.*;
import java.util.HashMap;

class CustomerEntry {
    private String name;
    private String mobileNumber;
    private String panCard;
    private double balance;


    // Constructor
    public CustomerEntry(String name, String mobileNumber, String panCard, double balance) throws SQLException {
        super();
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.panCard = panCard;
        this.balance = balance;


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012");
        // Prompt the user to enter account details
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Bank_Ac (Name, Phone_Number, PAN_Card, Balance) VALUES (?, ?, ?, ?)");
        pstmt.setString(1, name);
        pstmt.setString(2, mobileNumber);
        pstmt.setString(3, panCard);
        pstmt.setDouble(4, balance);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {

            System.out.println("Account details inserted successfully.");

        } else {
            System.out.println("Failed to insert account details.");
        }
    }

}