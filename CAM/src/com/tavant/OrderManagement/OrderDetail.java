package com.tavant.OrderManagement;
import java.util.*;
class OrderDetail {
    private int lineItem;
    private int quantity;
    private String taxStatus;
    private Item item;

    public OrderDetail(int lineItem, int quantity, String taxStatus, Item item) {
        this.lineItem = lineItem;
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }

    public float calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public double calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public float calcTax() {
        // Calculation of tax logic
        return 0; // Placeholder, implement your tax calculation logic here
    }

    public boolean inStock() {
        // Check if item is in stock
        return true; // Placeholder, implement your logic here
    }
}