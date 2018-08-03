package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.domain.Rental;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public class MotorCycleFactory {
    public static MotorCycle createMotorCycle(String SerialNumber, String Make, String Model, String year, /*String odometre, String FuelMeter,
                                              String Condition,*/String OdometreReading, String Gas, String BikeCondition,String EngineSerialNumber, String EngineSize, String FuelType,List<Rental> rentals)
    {
        MotorCycle motorCycle = new MotorCycle
                .Builder(SerialNumber)
                .Make(Make)
                .Model(Model)
                .year(year)
                .motorBikeCondition(MotorBikeCondtionFactory.createAddress(OdometreReading, Gas, BikeCondition))
                .engineTypeEmbeddable(EngineTypeEmbeddableFactory.createEngineTypeEmbeddable(EngineSerialNumber, EngineSize, FuelType))
                .rentals(rentals)
                .build();

        return motorCycle;
    }
}
