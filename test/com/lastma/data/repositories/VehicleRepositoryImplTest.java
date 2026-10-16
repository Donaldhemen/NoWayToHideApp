package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryImplTest {
    private VehicleRepositoryImpl vehicleRepository;
    private Vehicle vehicle;

    @BeforeEach
    void setup() {
        vehicleRepository = new VehicleRepositoryImpl();
        vehicle = new Vehicle();
    }

    @Test
    public void testThatWhenISaveVehicle_CountIsOne() {
        assertEquals(0L,vehicleRepository.count());
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
    }

    @Test
    public void testThatWhenTwoVehiclesAreSaved_CountIsTwo() {
        assertEquals(0L,vehicleRepository.count());
        Vehicle vehicleOne = new Vehicle();
        Vehicle vehicleTwo = new Vehicle();
        vehicleRepository.save(vehicleOne);
        vehicleRepository.save(vehicleTwo);
        assertEquals(2L,vehicleRepository.count());
    }

    @Test
    public void testThatWhenIFindByPlateNumber_VehicleIsFound() {
        vehicle.setPlateNumber("1");
        vehicleRepository.save(vehicle);
        assertEquals(vehicle,vehicleRepository.findByPlateNumber("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectPlateNumber_ErrorIsThrown() {
        vehicle.setPlateNumber("1");
        vehicleRepository.save(vehicle);
        assertThrows(IllegalArgumentException.class, () -> vehicleRepository.findByPlateNumber("6"));
    }

    @Test
    public void testThatWhenIDeleteVehicleWithPlateNumber_VehicleIsDeletedAndCountIsZero() {
        vehicle.setPlateNumber("1");
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
        vehicleRepository.del("1");
        assertEquals(0L,vehicleRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoVehicles_andDeleteAllCountIsZero(){
        assertEquals(0L,vehicleRepository.count());
        Vehicle vehicleOne = new Vehicle();
        Vehicle vehicleTwo = new Vehicle();
        vehicleRepository.save(vehicleOne);
        vehicleRepository.save(vehicleTwo);
        vehicleRepository.deleteAll();
        assertEquals(0L,vehicleRepository.count());
    }

    @Test
    public void testThatIfVehiclePlateNumberExists_ItIsTrue(){
        vehicle.setPlateNumber("1");
        vehicleRepository.save(vehicle);
        assertTrue(vehicleRepository.existsByPlateNumber("1"));
    }

    @Test
    public void testThatIfVehiclePlateNumberDoesNotExist_ItIsFalse(){
        vehicle.setPlateNumber("1");
        vehicleRepository.save(vehicle);
        assertFalse(vehicleRepository.existsByPlateNumber("2"));
    }

    @Test
    public void testThatIGetAllVehiclesWhenIFindAll(){
        assertEquals(0L,vehicleRepository.count());
        Vehicle vehicleOne = new Vehicle();
        Vehicle vehicleTwo = new Vehicle();
        vehicleRepository.save(vehicleOne);
        vehicleRepository.save(vehicleTwo);

        List<Vehicle> vehicles = vehicleRepository.findAll();
        assertEquals(2L, vehicles.size());
    }
}