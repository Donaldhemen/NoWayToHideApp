package com.lastma.services;

import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {

    private DriverService driverService;

    private DriverRepository driverRepository = new DriverRepositoryImpl();

    @BeforeEach
    void setUp() {
        driverService = new DriverServiceImpl();
    }

    @Test
    void testThatAfterRegisteringDriver_driverCountIsOne() {
        assertEquals(0L, driverRepository.count());
        driverService.register("Donald Hemen", "emali@example.com","password");
        assertEquals(1L, driverRepository.count());
    }
}