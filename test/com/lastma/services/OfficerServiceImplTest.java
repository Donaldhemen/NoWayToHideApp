package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.requests.FindOfficerRequest;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FindAllOfficerResponse;
import com.lastma.dtos.responses.FindOfficerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImplTest {
    private OfficerService officerService;
    private OfficerRepository officerRepository = new OfficerRepositoryImpl();
    private RegisterOfficerRequest registerRequest;
    private FindOfficerRequest findRequest;

    @BeforeEach
    public void setup() {
        officerService = new OfficerServiceImpl();
        registerRequest = new RegisterOfficerRequest();
        registerRequest.setFullName("Full Name");
        registerRequest.setEmail("email@example.com");
        registerRequest.setPhoneNumber("12345");
        findRequest = new FindOfficerRequest();
        officerRepository.deleteAll();
    }

    @Test
    public void testThatWhenIRegisterOfficer_CountIsOne(){
        assertEquals(0,officerRepository.count());
        officerService.registerOfficer(registerRequest);
        assertEquals(1,officerRepository.count());
    }

    @Test
    public void testThatWhenOfficerIsRegistered_idIsGenerated(){
        assertNotEquals(0,officerService.registerOfficer(registerRequest));
    }

    @Test
    public void testThatWhenOfficerIsRegistered_iCanFindOfficerById(){
        String officerId = officerService.registerOfficer(registerRequest).getId();

        findRequest.setOfficerId(officerId);
        Officer savedOfficerInRepo = officerRepository.findById(officerId);
        FindOfficerResponse savedOfficerByService = officerService.findOfficerBy(findRequest);
        assertEquals(savedOfficerInRepo.getId(),savedOfficerByService.getId());
    }

    @Test
    public void testThatWhenIFindOfficerByInvalidId_ErrorIsThrown(){
        findRequest.setOfficerId("6");
        assertThrows(IllegalArgumentException.class,() -> officerService.findOfficerBy(findRequest));
    }

    @Test
    public void testThatWhenIFindAllOfficers_iCanFindAllOfficers(){
        officerService.registerOfficer(registerRequest);
        officerService.registerOfficer(registerRequest);
        officerService.registerOfficer(registerRequest);
        assertEquals(officerRepository.findAll().size(),officerService.findAllOfficer().size());
        List<FindAllOfficerResponse> officersFromService = officerService.findAllOfficer();
        List<Officer> officersFromRepo = officerRepository.findAll();
        for( int index = 0; index < officersFromRepo.size(); index++ ){
            assertEquals(officersFromRepo.get(index).getId(),officersFromService.get(index).getId());
            assertEquals(officersFromRepo.get(index).getFullName(),officersFromService.get(index).getFullName());
            assertEquals(officersFromRepo.get(index).getPhoneNumber(),officersFromService.get(index).getPhoneNumber());
        }
    }

}