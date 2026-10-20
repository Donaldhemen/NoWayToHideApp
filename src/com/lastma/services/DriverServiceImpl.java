package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;

public class DriverServiceImpl implements DriverService{

    private DriverRepository driverRepository = new DriverRepositoryImpl();

    @Override
    public void register(String fullName, String mail) {
        Driver newDriver = new Driver();
        newDriver.setFullName(fullName);
        newDriver.setEmail(mail);
        driverRepository.save(newDriver);
    }
}
