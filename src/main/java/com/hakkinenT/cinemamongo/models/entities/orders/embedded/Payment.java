package com.hakkinenT.cinemamongo.models.entities.orders.embedded;

import com.hakkinenT.cinemamongo.models.entities.orders.enums.PaymentType;

public class Payment {
    PaymentType type;

    public Payment() {
    }

    public Payment(PaymentType type) {
        this.type = type;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    
}
