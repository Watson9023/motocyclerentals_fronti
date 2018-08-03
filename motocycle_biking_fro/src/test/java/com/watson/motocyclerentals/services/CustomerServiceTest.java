package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.App;
import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.CustomerFactory;
import com.watson.motocyclerentals.factories.RentalFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Long on 6/29/2018.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private CustomerService service;

    //@Test
    public void create() throws Exception {
        //Create a Customer Class


        List<PaymentMethod> paymentMethods1 = new ArrayList();
        List<Rental> rental = new ArrayList();

        PaymentMethod paymentMethod1 = new PaymentMethod.Builder("Credit").Price(400.00).build();
        paymentMethods1.add(paymentMethod1);


        Rental rental1 = RentalFactory.createRental("11/05/2018", "12-05-2018", paymentMethods1);
        rental.add(rental1);


        Customer customer= CustomerFactory
                .createCustomer("Wendy", "Doet", "0843024829", "5 Gimpie street Woodstock", "Cape Town", "8001", rental);
        // Save in the Database
        service.save(customer);
        //Id Should be available
        id = customer.getId();
        Assert.assertNotNull(customer);

    }

    // @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get Customer
        Customer customer = service.findById(id);
        Assert.assertEquals("Wendy", customer.getFirstName());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {
        //Get Customer
        Customer customer = service.findById(id);
        //Change it
        Customer newCustomer = new Customer
                .Builder(customer.getLastName())
                .copy(customer)
                .firstName("Linda").build();
        //Save it
        service.update(newCustomer);
        //Get Updated Customer
        Customer updatedCustomer = service.findById(id);
        Assert.assertEquals("Linda", updatedCustomer.getFirstName());

    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer customer = service.findById(id);
        service.delete(customer);
        Customer deletedCustomer = service.findById(id);
        Assert.assertNull(deletedCustomer);
    }
}

