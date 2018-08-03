package com.watson.motocyclerentals.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long on 6/29/2018.
 */
@Entity
public class PaymentMethod implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String PaymentType;
    private double Price;

    private PaymentMethod()

    {

    }

    public PaymentMethod(Builder builder) {
        this.id = builder.id;
        this.PaymentType = builder.PaymentType;
        this.Price = builder.Price;
    }

    public Long getId() {
        return id;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public double getPrice() {
        return Price;
    }


    public static class Builder {
        private Long id;
        private String PaymentType;
        private double Price;

        public Builder(String PaymentType) {
            this.PaymentType = PaymentType;
        }

        public Builder Price(double Price) {
            this.Price = Price;
            return this;
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(PaymentMethod paymentMethod) {
            this.id = paymentMethod.id;
            this.PaymentType = paymentMethod.PaymentType;
            this.Price = paymentMethod.Price;
            return this;
        }

        public PaymentMethod build() {
            return new PaymentMethod(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PaymentMethod paymentMethod = (PaymentMethod) o;

        return id.equals(paymentMethod.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PaymentMethodFactory{" +
                "id=" + id +
                ", PaymentType='" + PaymentType + '\'' +
                ", Price=" + Price +
                '}';
    }
}
