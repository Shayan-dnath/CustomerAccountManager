package com.tavant.CAM;
import java.util.*;
import java.sql.*;



public class CustomerAccountManager extends TransactionManager{
    public static void main(String[] args) throws SQLException {

        TransactionManager transactionManager = new TransactionManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Welcome to ABC Bank");
        while (true) {

            double balance = 0.0;
            String enteredPassword;
            int accountNumber;
            System.out.println(" ");

            System.out.println("Select an Option:");
            System.out.println("1. New Customer? Open an Account");
            System.out.println("2. Already a Customer? Log in to your Account");
            System.out.println("3. Exit Bank Application");

            int c = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            switch (c) {
                case 1:
                    // Open an Account
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mobileNumber = scanner.nextLine();
                    System.out.println("Enter PAN Card:");
                    String panCard = scanner.nextLine();

                    CustomerEntry account = new CustomerEntry(name, mobileNumber, panCard, balance);


                    System.out.println("Account opened successfully.");

                    break;
                case 2: {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Enter Your Account Number");
                    accountNumber = sc.nextInt(); // Change this to the desired account number
                    System.out.println("Enter Your Password");
                    enteredPassword = sc.next();


                    if (Authentication(accountNumber, enteredPassword)) {
                        System.out.println("\n");
                        System.out.println("Authentication Successful");
                        boolean exit=false;
                        while (!exit) {
                            System.out.println("\n");
                            System.out.println("Select an Option:");
                            System.out.println("1. Check Balance of Existing Account");
                            System.out.println("2. Make a Deposit");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Make Changes to Existing Account");
                            System.out.println("5. Return to Login Page");
                            System.out.println("6. Exit Bank Application");

                            int choice = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice) {

                                case 1:
                                    // Check Balance of Existing Account

                                    displaybalance(accountNumber, enteredPassword);
                                    break;
                                case 2:
                                    // Make a Deposit
                                    Scanner sc1 = new Scanner(System.in);


                                    System.out.println("Enter Amount to Deposit");
                                    double depositAmount = sc1.nextDouble();

                                    deposit(accountNumber, depositAmount);
                                    break;
                                case 3:
                                    // Withdraw Money
                                    Scanner sc2 = new Scanner(System.in);

                                    System.out.println("Enter Amount to Withdraw");
                                    double withdrawAmount = sc2.nextDouble();

                                    withdraw(accountNumber, withdrawAmount);
                                    break;
                                case 4:
                                    // Make Changes to Existing Account
                                    Scanner sc3 = new Scanner(System.in);
                                    System.out.println("\n");
                                    System.out.println("Enter New Name");
                                    String newName = sc3.next();
                                    System.out.println("Enter New Number");
                                    String newNumber = sc3.next();

                                    CustomerEdit edit = new CustomerEdit(newName, newNumber, accountNumber);

                                    break;
                                case 5:
                                    // Exit
                                    System.out.println("Returning...");
                                    exit=true;
                                    break;
                                case 6:
                                    System.out.println("Thank You for using ABC Banking Services");
                                    System.out.println("Exiting...");
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                        }
                    }
                }
                break;
                case 3:
                    System.out.println("Thank You for using ABC Banking Services");
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}






























/*
package com.tavant.CAM;
import java.util.*;
import java.util.logging.Logger;
import java.sql.*;

public class CustomerAccountManager {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        TransactionManager transactionManager = new TransactionManager();
        System.out.println(" ");
        System.out.println("Welcome to ABC Bank");

                while (true) {

                    double balance=0.0;
                    String enteredPassword="";
                    int accountNumber=0;
                    System.out.println(" ");

                    System.out.println("Select an option:");
                    System.out.println("1. Open an Account");
                    System.out.println("2. Check Balance of Existing Account");
                    System.out.println("3. Make a Deposit");
                    System.out.println("4. Withdraw Money");
                    System.out.println("5. Make Changes to Existing Account");
                    System.out.println("6. Exit");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline


                    switch (choice) {
                        case 1:
                            // Open an Account
                            System.out.println("Enter Name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter Mobile Number:");
                            String mobileNumber = scanner.nextLine();
                            System.out.println("Enter PAN Card:");
                            String panCard = scanner.nextLine();

                            CustomerEntry account = new CustomerEntry(name, mobileNumber, panCard, balance);
                            Logger logger = Logger.getLogger("CustomerTransactions");

                            System.out.println("Account opened successfully.");
                            transactionManager.addLogger(account, logger);

                            break;
                        case 2:
                            // Check Balance of Existing Account
                            Scanner sc=new Scanner(System.in);
                            TransactionManager T1=new TransactionManager();

                            System.out.println("Enter Your Account Number");
                            accountNumber = scanner.nextInt(); // Change this to the desired account number
                            System.out.println("Enter Your Password");
                            enteredPassword = sc.next(); // Change this to the password entered by the user

                            T1.displaybalance(accountNumber,enteredPassword);

                            break;
                        case 3:
                            // Make a Deposit
                            Scanner sc1=new Scanner(System.in);
                            TransactionManager T2=new TransactionManager();

                            System.out.println("Enter Your Account Number");
                            accountNumber = sc1.nextInt(); // Change this to the desired account number
                            System.out.println("Enter Your Password");
                            enteredPassword = sc1.next();


                            if(T2.Authentication(accountNumber, enteredPassword)) {
                                System.out.println("Authentication Successful");
                                System.out.println("Enter Amount to Deposit");
                                double depositAmount=sc1.nextDouble();
                                T2.deposit(accountNumber, depositAmount);
                            }

                            break;
                        case 4:
                            // Withdraw Money
                            Scanner sc2=new Scanner(System.in);
                            TransactionManager T3=new TransactionManager();

                            System.out.println("Enter Your Account Number");
                            accountNumber = sc2.nextInt(); // Change this to the desired account number
                            System.out.println("Enter Your Password");
                            enteredPassword = sc2.next();


                            if(T3.Authentication(accountNumber, enteredPassword)) {
                                System.out.println("Authentication Successful");
                                System.out.println("Enter Amount to Withdraw");
                                double withdrawAmount=sc2.nextDouble();
                                T3.withdraw(accountNumber, withdrawAmount);
                            }
                            break;

                        case 5:
                            // Make Changes to Existing Account
                            Scanner sc3=new Scanner(System.in);
                            TransactionManager T4=new TransactionManager();

                            System.out.println("Enter Account Number");
                            accountNumber = sc3.nextInt(); // Change this to the desired account number
                            System.out.println("Enter Your Password");
                            enteredPassword = sc3.next();
                            if(T4.Authentication(accountNumber, enteredPassword)) {
                                System.out.println("Authentication Successful");
                                System.out.println("\n");
                                System.out.println("Enter New Name");
                                String newName=sc3.next();
                                System.out.println("Enter New Number");
                                String newNumber=sc3.next();

                                CustomerEdit edit=new CustomerEdit(newName,newNumber,accountNumber);
                            }

                            break;
                        case 6:
                            // Exit
                            System.out.println("Exiting...");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");

                    }
                }
            }
        }

*/