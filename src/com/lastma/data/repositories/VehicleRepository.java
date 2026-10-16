package com.lastma.data.repositories;


import com.lastma.data.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    long count();

    void save(Vehicle vehicle);

    Vehicle findByPlateNumber(String plateNumber);

    void del(String plateNumber);

    void deleteAll();

    boolean existsByPlateNumber(String plateNumber);

    List<Vehicle> findAll();
}
