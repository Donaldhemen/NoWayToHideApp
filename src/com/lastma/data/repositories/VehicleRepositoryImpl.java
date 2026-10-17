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
    public Vehicle findByPlateNumber(String plateNumber) {
        for(Vehicle forEachVehicleIn : vehicles){
            if(forEachVehicleIn.getPlateNumber() == plateNumber){
                return forEachVehicleIn;
            }
        }
        throw new IllegalArgumentException("Vehicle with plate number " + plateNumber + " not found");
    }

    @Override
    public void del(String plateNumber) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getPlateNumber() == plateNumber){
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
    public boolean existsByPlateNumber(String plateNumber) {
        for(Vehicle forEachVehicleIn : vehicles){
            if(forEachVehicleIn.getPlateNumber() == plateNumber){
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
