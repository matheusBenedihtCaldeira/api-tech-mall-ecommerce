package com.techMall.api.models.enums;

public enum OrderStatus {
    PENDING("pending"),
    PROCESSING("processing"),
    CONCLUDED("concluded"),
    CANCELED("canceled");

    private String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}