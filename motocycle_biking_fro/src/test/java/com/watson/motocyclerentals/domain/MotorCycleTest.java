package com.watson.motocyclerentals.domain;

import com.watson.motocyclerentals.factories.MotorCycleFactory;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;


/**
 * Created by Long on 6/29/2018.
 */
public class MotorCycleTest {
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        MotorCycle motorCycle = MotorCycleFactory.createMotorCycle("HON34AA", "Honda", "CBR", "2006", "2000km", "full", "Mint ", "600ccsd", "600cc", "Unleaded ", null);

        Assert.assertEquals("Honda", motorCycle.getMake());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        MotorCycle motorCycle = MotorCycleFactory.createMotorCycle("HON3AA", "Honda", "CBR", "2006", "2000km", "full", "Mint ", "600ccsd", "600cc", "Unleaded ", null);

        MotorCycle newMotorCycle = new MotorCycle.Builder(motorCycle.getSerialNumber())
                .copy(motorCycle)
                .Model("VFR")
                .build();

        Assert.assertEquals("CBR", motorCycle.getModel());
        Assert.assertEquals("VFR", newMotorCycle.getModel());
    }

}