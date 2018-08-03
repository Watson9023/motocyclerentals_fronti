package com.watson.motocyclerentals.services.lmpl;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.repository.CustomerRepository;
import com.watson.motocyclerentals.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allcustomers = new ArrayList();
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allcustomers.add(customer);
        }
        return allcustomers;
    }

}
