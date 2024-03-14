package com.tavant.OrderManagement;
import java.util.*;
class Order {
    final String customer;
    Date date;
    String status;
    private List<OrderDetail> orderDetails;
    Payment payment;



        public Order(Date date, String status, String customer, Payment payment, OrderDetail[] orderDetails) {
            this.date = date;
            this.status = status;
            this.customer = customer;
            this.payment = payment;
            this.orderDetails = List.of(orderDetails);
        }


    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }

    public float calcSubTotal() {
        float subtotal = 0;
        for (OrderDetail detail : orderDetails) {
            subtotal += detail.calcSubTotal();
        }
        return subtotal;
    }

    public float calcTax() {
        // Calculation of tax logic
        return 0; // Placeholder, implement your tax calculation logic here
    }

    public float calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public float calcTotalWeight() {
        float totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight();
        }
        return totalWeight;
    }
}