package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.requests.FindOfficerRequest;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindAllOfficerResponse;
import com.lastma.dtos.responses.FindOfficerResponse;
import com.lastma.dtos.responses.RegisterOfficerResponse;

import java.util.List;

import static com.lastma.utils.OfficerServiceMapper.*;

public class OfficerServiceImpl implements OfficerService {
    private OfficerRepository officerRepository = new OfficerRepositoryImpl();

    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest officerRequest) {
        Officer newOfficer = map(officerRequest);
        officerRepository.save(newOfficer);

        return mapRegistered(newOfficer);
    }

    @Override
    public FindOfficerResponse findOfficerBy(FindOfficerRequest request) {
        Officer officer = officerRepository.findById(request.getOfficerId());
        validate(officer);

        return mapFound(officer);
    }

    @Override
    public List<FindAllOfficerResponse> findAllOfficer() {
        List<Officer> foundOfficers = officerRepository.findAll();

        return mapListOf(foundOfficers);
    }

    private void validate(Officer officer) {if(officer == null) throw new IllegalArgumentException("Officer not found");}
}
