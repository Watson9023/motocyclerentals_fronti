package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.EngineTypeEmbeddable;

/**
 * Created by Long on 6/29/2018.
 */
public class EngineTypeEmbeddableFactory {
    public static EngineTypeEmbeddable createEngineTypeEmbeddable(String EngineSerialNumber, String EngineSize, String FuelType)
    {
        EngineTypeEmbeddable engineTypeEmbeddable = new EngineTypeEmbeddable
                .Builder(EngineSerialNumber)
                .EngineSize(EngineSize)
                .FuelType(FuelType)
                .build();

        return engineTypeEmbeddable;
    }
}
