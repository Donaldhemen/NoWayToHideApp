package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository {
    private List<Driver> drivers = new ArrayList<>();

    @Override
    public long count() {
        return drivers.size();
    }

    @Override
    public void save(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public Driver findById(int id) {
        for(Driver forEachDriverIn : drivers){
            if(forEachDriverIn.getId() == id){
                return forEachDriverIn;
            }
        }
        throw new IllegalArgumentException("Driver with id " + id + " not found");
    }

    @Override
    public void del(int id) {
        for(Driver driver : drivers){
            if(driver.getId() == id){
                drivers.remove(driver);
                break;
            }
        }
    }
}
