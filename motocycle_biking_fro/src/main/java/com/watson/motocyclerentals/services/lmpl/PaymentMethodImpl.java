package com.watson.motocyclerentals.services.lmpl;

import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.repository.PaymentMethodRepository;
import com.watson.motocyclerentals.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@Service
public class PaymentMethodImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodRepository repository;
    public List<PaymentMethod> getPaymentMethod() {
        List<PaymentMethod> allPaymentMethods = new ArrayList<PaymentMethod>();

        Iterable<PaymentMethod> paymentMethods = repository.findAll();
        for (PaymentMethod paymentMethod : paymentMethods) {
            allPaymentMethods.add(paymentMethod);
        }
        return allPaymentMethods;
    }
}
