package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.MotorBikeConditionEmbeddable;

/**
 * Created by Long on 6/29/2018.
 */
public class MotorBikeCondtionFactory {
    public static MotorBikeConditionEmbeddable createAddress(String OdometreReading, String Gas, String BikeCondition)
    {
        MotorBikeConditionEmbeddable addressEmbeddable = new MotorBikeConditionEmbeddable
                .Builder(OdometreReading)
                .Gas(Gas)
                .BikeCondition(BikeCondition)
                .build();

        return addressEmbeddable;
    }
}
