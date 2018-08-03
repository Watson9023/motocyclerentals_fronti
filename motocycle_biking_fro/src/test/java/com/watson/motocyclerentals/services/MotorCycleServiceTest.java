package com.watson.motocyclerentals.services;
import com.watson.motocyclerentals.App;
import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.MotorCycleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Long on 6/29/2018.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class MotorCycleServiceTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private MotorCycleService service;

    //@Test
    public void create() throws Exception {
        //Create a MotorCycle Class


        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-07-2018").returnDate("28-07-2018").paymentMethod(paymentMethods).build();
        rentals.add(rental);

        MotorCycle motorCycle = MotorCycleFactory
                .createMotorCycle("HondCB2424", "Honda", "Cbr", "2006", "200km", "Half Tank", "Mint ", "1000cccbr", "600cc", "Unleaded ", rentals);
        // Save in the Database
        service.save(motorCycle);
        //Id Should be available
        id = motorCycle.getId();
        Assert.assertNotNull(motorCycle);

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        MotorCycle motorCycle = service.findById(id);
        Assert.assertEquals("2006", motorCycle.getYear());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {
        //Get MotorCycle
        MotorCycle motorCycle = service.findById(id);
        //Change it
        MotorCycle newMotorCycle = new MotorCycle
                .Builder(motorCycle.getSerialNumber())
                .copy(motorCycle)
                .year("2010").build();
        //Save it
        service.update(newMotorCycle);
        //Get Updated MotorCycle
        MotorCycle updatedMotorCycle = service.findById(id);
        Assert.assertEquals("2010", updatedMotorCycle.getYear());

    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        MotorCycle motorCycle = service.findById(id);
        service.delete(motorCycle);
        MotorCycle deletedMotorCycle = service.findById(id);
        Assert.assertNull(deletedMotorCycle);
    }

}