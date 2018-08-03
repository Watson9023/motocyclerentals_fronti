package com.watson.motocyclerentals.services.lmpl;

import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.repository.RentalRepository;
import com.watson.motocyclerentals.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@Service
public class RentalImpl implements RentalService {

    @Autowired
    private RentalRepository repository;

    @Override
    public Rental findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Rental save(Rental entity) {
        return repository.save(entity);
    }

    @Override
    public Rental update(Rental entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Rental entity) {
        repository.delete(entity);

    }

    @Override
    public List<Rental> findAll() {
        List<Rental> allRentals = new ArrayList();
        Iterable<Rental> rentals = repository.findAll();
        for (Rental rental : rentals) {
            allRentals.add(rental);
        }
        return allRentals;
    }
}
