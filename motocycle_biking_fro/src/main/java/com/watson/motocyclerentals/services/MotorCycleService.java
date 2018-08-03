package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.MotorCycle;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public interface MotorCycleService extends Services<MotorCycle,Long> {
        List<MotorCycle> getMotorCycles();
        // List<Rental> getRental(Long id);
}
