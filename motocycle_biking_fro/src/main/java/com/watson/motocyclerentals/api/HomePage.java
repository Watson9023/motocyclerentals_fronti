package com.watson.motocyclerentals.api;

import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.EngineTypeEmbeddableFactory;
import com.watson.motocyclerentals.factories.MotorBikeCondtionFactory;
import com.watson.motocyclerentals.services.MotorCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private MotorCycleService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/motorcycle",method = RequestMethod.GET)
    public MotorCycle getMotorCycle(){

        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);
        Rental rental = new Rental.Builder("22-07-2018").returnDate("28-07-2018").paymentMethod(paymentMethods).build();
        rentals.add(rental);
        MotorCycle couse = new MotorCycle
                .Builder("kawa2345")
                .Make("Kawasaki")
                .Model("Ninja")
                .year("2009")
                .motorBikeCondition(MotorBikeCondtionFactory.createAddress("20000", "Full", "Mint"))
                .engineTypeEmbeddable(EngineTypeEmbeddableFactory.createEngineTypeEmbeddable("600ccxerghc", "600cc", "Petrol"))
                .rentals(rentals)
                .build();

        return couse;
    }

    @RequestMapping(value = "motorcycles", method = RequestMethod.GET)
    public List<MotorCycle> getMotorCycles(){
        return service.getMotorCycles();
    }
}
