package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.SalesPerson;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public class SalesPersonFactory {
    public static SalesPerson createSalesPerson(String firstName, String lastName, int hours, double rate, String username, String password, List<Customer> customers)
    {
        SalesPerson salesPerson = new SalesPerson
                .Builder(lastName)
                .firstName(firstName)
                .hours(hours)
                .rate(rate)
                .customers(customers)
                .build();
        return salesPerson;
    }
}
