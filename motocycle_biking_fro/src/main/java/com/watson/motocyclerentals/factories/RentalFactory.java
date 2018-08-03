package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public class RentalFactory {
    public static Rental createRental(String pickUpdate, String returnDate,  List<PaymentMethod> paymentMethod)
    {
        Rental rental = new Rental
                .Builder(pickUpdate)
                .returnDate(returnDate)
                .paymentMethod(paymentMethod)
                .build();
        return rental;
    }
}
