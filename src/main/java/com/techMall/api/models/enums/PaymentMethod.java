package com.techMall.api.models.enums;

public enum PaymentMethod {

    CREDIT_CARD("creditCard"),
    PIX("pix"),
    DEBIT("debit"),
    ticket("ticket");

    private String paymentMathod;

    PaymentMethod(String paymentMathod) {
        this.paymentMathod = paymentMathod;
    }

    public String getPaymentMathod() {
        return paymentMathod;
    }

    public void setPaymentMathod(String paymentMathod) {
        this.paymentMathod = paymentMathod;
    }
}