package com.watson.motocyclerentals.domain;

import static org.junit.Assert.*;

import com.watson.motocyclerentals.factories.RentalFactory;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
/**
 * Created by Long on 6/29/2018.
 */
public class RentalTest {
   @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        Rental rental = RentalFactory.createRental("22-05-2018", "28-05-2018", null);

        Assert.assertEquals("28-05-2018", rental.getReturnDate());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        Rental rental = RentalFactory.createRental("22-05-2018", "28-05-2018", null);

        Rental newRental = new Rental.Builder(rental.getPickUpDate())
                .copy(rental)
                .returnDate("30-05-2018")
                .build();

        Assert.assertEquals("28-05-2018", rental.getReturnDate());
        Assert.assertEquals("30-05-2018", newRental.getReturnDate());
    }
}