package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository {
    private static List<Driver> drivers = new ArrayList<>();

    @Override
    public long count() {
        return drivers.size();
    }

    @Override
    public void save(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public Driver findById(String id) {
        for(Driver forEachDriverIn : drivers){
            if(forEachDriverIn.getId().equals(id)){
                return forEachDriverIn;
            }
        }
        throw new IllegalArgumentException("Driver with id " + id + " not found");
    }

    @Override
    public void deleteById(String id) {
        for(Driver driver : drivers){
            if(driver.getId().equals(id)){
                drivers.remove(driver);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        drivers.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Driver forEachDriverIn : drivers){
            if(forEachDriverIn.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Driver> findAll() {
        return drivers;
    }
}
