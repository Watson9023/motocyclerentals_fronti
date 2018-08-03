package com.watson.motocyclerentals.domain;

import com.watson.motocyclerentals.factories.PaymentMethodFactory;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import static org.junit.Assert.*;

/**
 * Created by Long on 6/29/2018.
 */
public class PaymentMethodTest {
    @Before
    public void setUp() throws Exception
    {

    }

   @Test
    public void testCreateAdmin() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Credit", 200.00);
        Assert.assertEquals(200.00, paymentMethod.getPrice(), 0.2f);
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Debit", 200.00);

        PaymentMethod newPaymentMethod = new PaymentMethod.Builder(paymentMethod.getPaymentType())
                .copy(paymentMethod)
                .Price(800.00)
                .build();

        Assert.assertEquals(200.00, paymentMethod.getPrice(), 0.2f);
        Assert.assertEquals(800.00,newPaymentMethod.getPrice(), 0.2f);
    }


}