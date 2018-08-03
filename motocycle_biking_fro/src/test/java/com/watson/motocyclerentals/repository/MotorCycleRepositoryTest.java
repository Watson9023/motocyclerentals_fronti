package com.watson.motocyclerentals.repository;
import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.MotorCycleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import com.watson.motocyclerentals.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class MotorCycleRepositoryTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private MotorCycleRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {

        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-07-2018").returnDate("28-07-2018").paymentMethod(paymentMethods).build();
        rentals.add(rental);
        MotorCycle motorCycle = MotorCycleFactory.createMotorCycle("kawa34er", "Kawasaki", "Ninja", "2006", "2000km", "full", "Mint ", "600ccsd", "600cc", "Unleaded ", rentals);

        repository.save(motorCycle);

        id = motorCycle.getId();

        Assert.assertNotNull(motorCycle.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        MotorCycle motorCycle = repository.findOne(id);
        Assert.assertNotNull(motorCycle);
        Assert.assertEquals("kawa34er", motorCycle.getSerialNumber());
        Assert.assertEquals("Kawasaki", motorCycle.getMake());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        MotorCycle motorCycle = (MotorCycle)this.repository.findOne(this.id);
        MotorCycle newMotorCycle =  new MotorCycle.Builder(motorCycle.getSerialNumber()).copy(motorCycle).year("2018").build();
        this.repository.save(newMotorCycle);
        MotorCycle updatedMotorCycle = (MotorCycle)this.repository.findOne(this.id);
        Assert.assertEquals("2018", updatedMotorCycle.getYear());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        MotorCycle motorCycle = repository.findOne(id);

        repository.delete(motorCycle);
        MotorCycle deletedMotorCycle = repository.findOne(id);
        Assert.assertNull(deletedMotorCycle);

    }
}