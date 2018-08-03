package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.AddressEmbeddable;

/**
 * Created by Long on 6/29/2018.
 */
public class AddressEmbeddableFactory {
    public static AddressEmbeddable createAddress(String Address, String City, String postalCode)
    {
        AddressEmbeddable addressEmbeddable = new AddressEmbeddable
                .Builder(Address)
                .City(City)
                .postalCode(postalCode)
                .build();

        return addressEmbeddable;



    }
}
