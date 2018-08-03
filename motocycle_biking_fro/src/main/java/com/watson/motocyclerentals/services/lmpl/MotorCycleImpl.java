package com.watson.motocyclerentals.services.lmpl;

import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.repository.MotorCycleRepository;
import com.watson.motocyclerentals.services.MotorCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@Service
public class MotorCycleImpl implements MotorCycleService {
    @Autowired
    private MotorCycleRepository repository;
    public List<MotorCycle> getMotorCycles() {
        List<MotorCycle> allMotorCycles = new ArrayList<MotorCycle>();

        Iterable<MotorCycle> motorCycles = repository.findAll();
        for (MotorCycle motorCycle : motorCycles) {
            allMotorCycles.add(motorCycle);
        }
        return allMotorCycles;
    }

    @Override
    public MotorCycle findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public MotorCycle save(MotorCycle entity) {
        return repository.save(entity);
    }

    @Override
    public MotorCycle update(MotorCycle entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(MotorCycle entity) {
        repository.delete(entity);

    }

    @Override
    public List<MotorCycle> findAll() {
        List<MotorCycle> allMotorCycles = new ArrayList();
        Iterable<MotorCycle> motorcycles = repository.findAll();
        for (MotorCycle motorCycle : motorcycles) {
            allMotorCycles.add(motorCycle);
        }
        return allMotorCycles;
    }
}
