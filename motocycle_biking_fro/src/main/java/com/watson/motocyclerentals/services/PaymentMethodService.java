package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.PaymentMethod;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public interface PaymentMethodService {
    List<PaymentMethod> getPaymentMethod();
}
