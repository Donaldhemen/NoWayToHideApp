package com.lastma.utils;

import com.lastma.data.models.Officer;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindAllOfficerResponse;
import com.lastma.dtos.responses.FindOfficerResponse;
import com.lastma.dtos.responses.RegisterOfficerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OfficerServiceMapper {

    public static RegisterOfficerResponse mapRegistered(Officer Officer){
        RegisterOfficerResponse response = new RegisterOfficerResponse();
        response.setId(Officer.getId());
        response.setFullName(Officer.getFullName());
        response.setEmail(Officer.getEmail());
        response.setPhoneNumber(Officer.getPhoneNumber());
        return  response;
    }

    public static Officer map(RegisterOfficerRequest officerRequest){
        Officer officer = new Officer();
        officer.setId(UUID.randomUUID().toString());
        officer.setFullName(officerRequest.getFullName());
        officer.setEmail(officerRequest.getEmail());
        officer.setPhoneNumber(officerRequest.getPhoneNumber());
        return officer;
    }

    public static FindOfficerResponse mapFound(Officer  officer){
        FindOfficerResponse response = new FindOfficerResponse();
        response.setId(officer.getId());
        response.setFullName(officer.getFullName());
        response.setEmail(officer.getEmail());
        response.setPhoneNumber(officer.getPhoneNumber());
        return  response;
    }

    public static List<FindAllOfficerResponse> mapListOf(List<Officer> foundOfficers){
        List<FindAllOfficerResponse> responseList = new ArrayList<>();
        for( Officer officer : foundOfficers){
            FindAllOfficerResponse response = new FindAllOfficerResponse();
            response.setId(officer.getId());
            response.setFullName(officer.getFullName());
            response.setEmail(officer.getEmail());
            response.setPhoneNumber(officer.getPhoneNumber());
            responseList.add(response);
        }
        return responseList;
    }
}
