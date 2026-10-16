package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverRepositoryImplTest {
    private DriverRepositoryImpl driverRepository;
    private Driver driver;

    @BeforeEach
    void setup() {
        driverRepository = new DriverRepositoryImpl();
        driver = new Driver();
    }

    @Test
    public void testThatWhenISaveDriver_CountIsOne() {
        assertEquals(0L,driverRepository.count());
        driverRepository.save(driver);
        assertEquals(1L,driverRepository.count());
    }

    @Test
    public void testThatWhenTwoDriversAreSaved_CountIsTwo() {
        assertEquals(0L,driverRepository.count());
        Driver driverOne = new Driver();
        Driver driverTwo = new Driver();
        driverRepository.save(driverOne);
        driverRepository.save(driverTwo);
        assertEquals(2L,driverRepository.count());
    }

    @Test
    public void testThatWhenIFindById_DriverIsFound() {
        driver.setId(1);
        driverRepository.save(driver);
        assertEquals(driver,driverRepository.findById(1));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        driver.setId(1);
        driverRepository.save(driver);
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findById(6));
    }

    @Test
    public void testThatWhenIDeleteDriverWithId_DriverIsDeletedAndCountIsZero() {
        driver.setId(1);
        driverRepository.save(driver);
        assertEquals(1L,driverRepository.count());
        driverRepository.del(1);
        assertEquals(0L,driverRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoDrivers_andDeleteAllCountIsZero(){
        assertEquals(0L,driverRepository.count());
        Driver driverOne = new Driver();
        Driver driverTwo = new Driver();
        driverRepository.save(driverOne);
        driverRepository.save(driverTwo);
        driverRepository.deleteAll();
        assertEquals(0L,driverRepository.count());
    }

    @Test
    public void testThatIfDriverIdExists_ItIsTrue(){
        driver.setId(1);
        driverRepository.save(driver);
        assertTrue(driverRepository.existsById(1));
    }

    @Test
    public void testThatIfDriverIdDoesNotExist_ItIsFalse(){
        driver.setId(1);
        driverRepository.save(driver);
        assertFalse(driverRepository.existsById(2));
    }

    @Test
    public void testThatIGetAllDriversWhenIFindAll(){
        assertEquals(0L,driverRepository.count());
        Driver driverOne = new Driver();
        Driver driverTwo = new Driver();
        driverRepository.save(driverOne);
        driverRepository.save(driverTwo);

        List<Driver> drivers = driverRepository.findAll();
        assertEquals(2L, drivers.size());
    }
}