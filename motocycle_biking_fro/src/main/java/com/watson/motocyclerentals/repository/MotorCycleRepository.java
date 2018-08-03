package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.domain.MotorCycle;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 6/29/2018.
 */
public interface MotorCycleRepository extends CrudRepository<MotorCycle,Long> {
}
