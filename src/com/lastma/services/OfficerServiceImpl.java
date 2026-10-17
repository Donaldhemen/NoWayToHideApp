package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;

public class OfficerServiceImpl implements OfficerService{

    private OfficerRepository officerRepository = new OfficerRepositoryImpl();

    @Override
    public void register(String fullName, String mail, String password) {
        Officer newOfficer = new Officer();
        newOfficer.setFullName(fullName);
        newOfficer.setEmail(mail);
        newOfficer.setPassword(password);
        officerRepository.save(newOfficer);
    }
}
