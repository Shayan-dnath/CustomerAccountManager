package com.tavant.OrderManagement;

import java.util.Date;

public class CallMain {
    public static void main(String[] args) {
        // Creating a customer
        Customer customer = new Customer("John Doe", "123 Main St");

        // Creating items
        Item item1 = new Item("Book", 1.5,30000);
        Item item2 = new Item("Phone", 0.5,1000);

        // Creating order details
        OrderDetail orderDetail1 = new OrderDetail(1, 2, "taxable", item1);
        OrderDetail orderDetail2 = new OrderDetail(2, 1, "exempt", item2);
        OrderDetail[] orderDetails = { orderDetail1, orderDetail2 };

        // Creating an order
        Date date = new Date();
        //Payment payment = new Cash(50);// Assuming payment is made with cash
        Payment payment = new Credit(31000.0f, "1234 5678 9012 3456", "12/25");
        Order order = new Order(date, "pending", customer.name, payment, orderDetails);

        // Displaying order details
        System.out.println("Order details:");
        System.out.println("Customer: " + order.customer);
        System.out.println("Date: " + order.date);
        System.out.println("Status: " + order.status);
        System.out.println("Payment amount: $" + order.payment.getAmount());
        System.out.println("Subtotal: $" + order.calcSubTotal());
        System.out.println("Tax: $" + order.calcTax());
        System.out.println("Total: $" + order.calcTotal());
        System.out.println("Total Weight: " + order.calcTotalWeight());
    }
}