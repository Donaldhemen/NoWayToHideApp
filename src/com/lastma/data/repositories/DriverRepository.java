package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

public interface DriverRepository {

    long count();

    void save(Driver driver);

    Driver findById(int id);

    void del(int id);
}
