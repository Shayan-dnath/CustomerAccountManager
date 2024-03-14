package com.tavant.CAM;
import java.sql.*;
import java.util.logging.Logger;


public class MonthlyInterestUpdate {


    // Method to deposit amount into the account
    public void monthlyUpdate() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=3012")) {
            // Define the monthly interest rate (you can adjust it according to your requirements)
            double monthlyInterestRate = (0.07/12); // 7% P.A. interest rate

            // Create a prepared statement to update the balance with monthly interest
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE Bank_Ac SET Balance = Balance + (Balance * ?)");

            // Set parameter for the monthly interest rate
            pstmt.setDouble(1, monthlyInterestRate);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();

            // Print the number of accounts updated
            System.out.println(rowsAffected + " accounts updated with monthly interest.");

            // Close the statement
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Logger interestLogger = null;
        MonthlyInterestUpdate month1=new MonthlyInterestUpdate();
        month1.monthlyUpdate();
        interestLogger.info("Monthly interest updated");;
    }
}
