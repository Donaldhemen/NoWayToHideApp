package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepository;
    private Officer officer;

    @BeforeEach
    void setup() {
        officerRepository = new OfficerRepositoryImpl();
        officer = new Officer();
    }

    @Test
    public void testThatWhenISaveOfficer_CountIsOne() {
        assertEquals(0L,officerRepository.count());
        officerRepository.save(officer);
        assertEquals(1L,officerRepository.count());
    }

    @Test
    public void testThatWhenTwoOfficersAreSaved_CountIsTwo() {
        assertEquals(0L,officerRepository.count());
        Officer officerOne = new Officer();
        Officer officerTwo = new Officer();
        officerRepository.save(officerOne);
        officerRepository.save(officerTwo);
        assertEquals(2L,officerRepository.count());
    }

    @Test
    public void testThatWhenIFindById_OfficerIsFound() {
        officer.setId("1");
        officerRepository.save(officer);
        assertEquals(officer,officerRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        officer.setId("1");
        officerRepository.save(officer);
        assertThrows(IllegalArgumentException.class, () -> officerRepository.findById("7"));
    }

    @Test
    public void testThatWhenIDeleteOfficerWithId_OfficerIsDeletedAndCountIsZero() {
        officer.setId("1");
        officerRepository.save(officer);
        assertEquals(1L,officerRepository.count());
        officerRepository.deleteById("1");
        assertEquals(0L,officerRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoOfficers_andDeleteAllCountIsZero(){
        assertEquals(0L,officerRepository.count());
        Officer officerOne = new Officer();
        Officer officerTwo = new Officer();
        officerRepository.save(officerOne);
        officerRepository.save(officerTwo);
        officerRepository.deleteAll();
        assertEquals(0L,officerRepository.count());
    }

    @Test
    public void testThatIfOfficerIdExists_ItIsTrue(){
        officer.setId("1");
        officerRepository.save(officer);
        assertTrue(officerRepository.existsById("1"));
    }

    @Test
    public void testThatIfOfficerIdDoesNotExist_ItIsFalse(){
        officer.setId("1");
        officerRepository.save(officer);
        assertFalse(officerRepository.existsById("4"));
    }

    @Test
    public void testThatIGetAllOfficersWhenIFindAll(){
        assertEquals(0L,officerRepository.count());
        Officer officerOne = new Officer();
        Officer officerTwo = new Officer();
        officerRepository.save(officerOne);
        officerRepository.save(officerTwo);

        List<Officer> officers = officerRepository.findAll();
        assertEquals(2L, officers.size());
    }
}