package com.lastma.services;

import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImplTest {

    private OfficerService officerService;

    private OfficerRepository officerRepository = new OfficerRepositoryImpl();

    @BeforeEach
    void setUp() {
        officerService = new OfficerServiceImpl();
    }

    @Test
    void testThatAfterRegisteringOfficer_officerCountIsOne() {
        assertEquals(0L, officerRepository.count());
        officerService.register("Donald Hemen", "emali@example.com");
        assertEquals(1L, officerRepository.count());
    }
}