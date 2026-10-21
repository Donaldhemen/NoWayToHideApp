package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.List;

public interface DriverRepository {

    long count();

    void save(Driver driver);

    Driver findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Driver> findAll();

}
