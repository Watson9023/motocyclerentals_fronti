package com.watson.motocyclerentals.modules;

import com.watson.motocyclerentals.domain.AddressEmbeddable;
import com.watson.motocyclerentals.domain.Person;
import com.watson.motocyclerentals.domain.Rental;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public class CustomerResource extends ResourceSupport implements Person {
    private Long resid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private AddressEmbeddable addressEmbeddable;
    private List<Rental> rentals;

    //constructors
    private CustomerResource()
    {

    }

    public CustomerResource(Builder builder)
    {
        this.resid = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.addressEmbeddable = builder.addressEmbeddable;
        this.rentals = builder.rentals;
    }

    //getters


    public Long getResid() {
        return resid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressEmbeddable getAddressEmbeddable() {
        return addressEmbeddable;
    }


    public List<Rental> getRentals() {
        return rentals;
    }


    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private AddressEmbeddable addressEmbeddable;
        private List<Rental> rentals;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder addressEmbeddable(AddressEmbeddable addressEmbeddable) {
            this.addressEmbeddable = addressEmbeddable;
            return this;
        }

        public Builder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource customer)
        {
            this.id = customer.resid;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.addressEmbeddable = customer.addressEmbeddable;
            this.rentals = customer.rentals;
            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerResource{" +
                "resid=" + resid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressEmbeddable=" + addressEmbeddable +
                ", rentals=" + rentals +
                '}';
    }
}
