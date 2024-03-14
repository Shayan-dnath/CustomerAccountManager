package com.tavant.OrderManagement;
import java.util.*;
class Item {
    private String description;
    private double shippingWeight;
    private float price;

    public Item(String description, double shippingWeight, float price) {
        this.description = description;
        this.shippingWeight = shippingWeight;
        this.price = price;
    }

    public float getPriceForQuantity(int quantity) {
        return price * quantity;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }
}