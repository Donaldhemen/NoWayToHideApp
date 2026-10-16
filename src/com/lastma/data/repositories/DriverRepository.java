package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.List;

public interface DriverRepository {

    long count();

    void save(Driver driver);

    Driver findById(int id);

    void del(int id);

    void deleteAll();

    boolean existsById(int id);

    List<Driver> findAll();

}
