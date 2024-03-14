package com.tavant.CAM;

import java.sql.*;

public class CustomerEdit {
    private String name;
    private String mobileNumber;
    private String panCard;
    private int accountNumber;

    public CustomerEdit(String name, String mobileNumber,int accountNumber) throws SQLException {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.accountNumber=accountNumber;


        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Create a prepared statement to update the name and phone number
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE Bank_Ac SET Name = ?, Phone_Number = ? WHERE Account_No = ?");

            // Set parameters for the new name, phone number, and account number
            pstmt.setString(1, name);
            pstmt.setString(2, mobileNumber);
            pstmt.setInt(3, accountNumber);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Details updated successfully for account number: " + accountNumber);
            } else {
                System.out.println("Failed to update details for account number: " + accountNumber);
            }

            // Close the statement
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }


    }
}