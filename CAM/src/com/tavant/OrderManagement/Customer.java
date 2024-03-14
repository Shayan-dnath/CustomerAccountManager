package com.tavant.OrderManagement;

import java.util.*;

class Customer {
    String name;
    private String address;
    private List<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }
}