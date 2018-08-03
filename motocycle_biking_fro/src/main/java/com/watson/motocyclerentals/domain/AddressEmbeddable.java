package com.watson.motocyclerentals.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import javax.persistence.Column;

/**
 * Created by Long on 6/29/2018.
 */
@Embeddable
public class AddressEmbeddable implements Serializable {

        private String Address;
        private String City;
        private String postalCode;

        //constructors
        private AddressEmbeddable()
        {

        }

        public AddressEmbeddable(Builder builder)
        {
            this.Address = builder.Address;
            this.City = builder.City;
            this.postalCode = builder.postalCode;
        }

        //getters
        public String getAddress()
        {
            return Address;
        }

        public String getCity()
        {
            return City;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public static class Builder
        {
            private String Address;
            private String City;
            private String postalCode;

            public Builder(String Address)
            {
                this.Address = Address;
            }

            public Builder City(String City)
            {
                this.City = City;
                return this;
            }

            public Builder postalCode(String postalCode)
            {
                this.postalCode = postalCode;
                return this;
            }

            public Builder copy(AddressEmbeddable addressEmbeddable)
            {
                this.Address = addressEmbeddable.Address;
                this.City = addressEmbeddable.City;
                this.postalCode = addressEmbeddable.postalCode;
                return this;
            }

            public AddressEmbeddable build()
            {
                return new AddressEmbeddable(this);
            }
        }
}
