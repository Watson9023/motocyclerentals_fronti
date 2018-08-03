package com.watson.motocyclerentals.services.lmpl;

import com.watson.motocyclerentals.domain.SalesPerson;
import com.watson.motocyclerentals.repository.SalesPersonRepository;
import com.watson.motocyclerentals.services.SalesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@Service
public class SalesPersonImpl implements SalesPersonService {
    @Autowired
    private SalesPersonRepository repository;

    @Override
    public SalesPerson findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public SalesPerson save(SalesPerson entity) {
        return repository.save(entity);
    }

    @Override
    public SalesPerson update(SalesPerson entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(SalesPerson entity) {
        repository.delete(entity);

    }

    @Override
    public List<SalesPerson> findAll() {
        List<SalesPerson> allSalesPersons = new ArrayList();
        Iterable<SalesPerson> salesPersons = repository.findAll();
        for (SalesPerson salesPerson : salesPersons) {
            allSalesPersons.add(salesPerson);
        }
        return allSalesPersons;
    }
}
