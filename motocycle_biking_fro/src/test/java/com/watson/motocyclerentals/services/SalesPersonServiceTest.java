package com.watson.motocyclerentals.services;
import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.domain.SalesPerson;
import com.watson.motocyclerentals.factories.AddressEmbeddableFactory;
import com.watson.motocyclerentals.factories.SalesPersonFactory;
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
public class SalesPersonServiceTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private SalesPersonService service;

    //@Test
    public void create() throws Exception {
        //Create a SalesPerson Class

        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();
        List<Customer> customers = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-07-2018").returnDate("28-07-2018").paymentMethod(paymentMethods).build();
        rentals.add(rental);

        Customer customer1 = new Customer.Builder("Watson").firstName("Matunhire").phoneNumber("0823334292").addressEmbeddable(AddressEmbeddableFactory.createAddress("5 baten street Woodstock", "Cape Town", "890890"))
                // .loginEmbeddable(LoginEmbeddableFactory.createLogin("user", "pass"))
                .rentals(rentals)
                .build();
        customers.add(customer1);

        SalesPerson salesPerson= SalesPersonFactory
                .createSalesPerson("Khaleesi", "Yonna", 8, 200.00, "kf", "fk100K", customers);
        // Save in the Database
        service.save(salesPerson);
        //Id Should be available
        id = salesPerson.getId();
        Assert.assertNotNull(salesPerson);

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get SalesPerson
        SalesPerson salesPerson = service.findById(id);
        Assert.assertEquals("Khaleesi", salesPerson.getFirstName());
    }

    // @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        //Get SalesPerson
        SalesPerson salesPerson = service.findById(id);
        //Change it
        SalesPerson newSalesPerson = new SalesPerson
                .Builder(salesPerson.getLastName())
                .copy(salesPerson)
                .firstName("Riyaaz").build();
        //Save it
        service.update(newSalesPerson);
        //Get Updated SalesPerson
        SalesPerson updatedSalesPerson = service.findById(id);
        Assert.assertEquals("Riyaaz", updatedSalesPerson.getFirstName());

    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        SalesPerson salesPerson = service.findById(id);
        service.delete(salesPerson);
        SalesPerson deletedSalesPerson = service.findById(id);
        Assert.assertNull(deletedSalesPerson);
    }

}