package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle findById(String id) {
        for(Vehicle forEachVehicleIn : vehicles){
            if(forEachVehicleIn.getId() == id){
                return forEachVehicleIn;
            }
        }
        throw new IllegalArgumentException("Vehicle with id " + id + " not found");
    }

    @Override
    public void del(String id) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getId() == id){
                vehicles.remove(vehicle);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Vehicle forEachVehicleIn : vehicles){
            if(forEachVehicleIn.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }
}

