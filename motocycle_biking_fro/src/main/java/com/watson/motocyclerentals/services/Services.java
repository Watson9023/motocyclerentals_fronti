package com.watson.motocyclerentals.services;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
public interface Services<S,ID> {
    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
