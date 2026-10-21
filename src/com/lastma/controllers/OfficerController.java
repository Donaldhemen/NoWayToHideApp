package com.lastma.controllers;

import com.lastma.dtos.requests.FindOfficerRequest;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.ApiResponse;
import com.lastma.services.OfficerService;
import com.lastma.services.OfficerServiceImpl;

public class OfficerController {
    private OfficerService officerService = new OfficerServiceImpl();

    public ApiResponse registerOfficer(RegisterOfficerRequest request){
        try {
            return new ApiResponse(true, officerService.registerOfficer(request));
        }
        catch (Exception e){
            return new ApiResponse(false, e.getMessage());
        }
    }

    public ApiResponse findOfficerBy(FindOfficerRequest request){
        try {
            return new ApiResponse(true, officerService.findOfficerBy(request));
        }
        catch (Exception e){
            return new ApiResponse(false, e.getMessage());
        }
    }

    public ApiResponse findAllOfficer(){
        try {
            return new ApiResponse(true, officerService.findAllOfficer());
        }
        catch (Exception e){
            return new ApiResponse(false, e.getMessage());
        }
    }
}
