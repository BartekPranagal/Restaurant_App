package com.example.restaurant_app.model.dto;

public enum OrderType {

    DELIVERY(15),
    TAKEAWAY(0);

    private int deliveryCost;

    OrderType(int deliveryCost) {

    }
}
