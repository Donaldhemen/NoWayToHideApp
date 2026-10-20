package com.lastma.data.repositories;

import com.lastma.data.models.Offence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OffenceRepositoryImplTest {
    private OffenceRepositoryImpl offenceRepository;
    private Offence offence;

    @BeforeEach
    void setup() {
        offenceRepository = new OffenceRepositoryImpl();
        offence = new Offence();
    }

    @Test
    public void testThatWhenISaveOffence_CountIsOne() {
        assertEquals(0L,offenceRepository.count());
        offenceRepository.save(offence);
        assertEquals(1L,offenceRepository.count());
    }

    @Test
    public void testThatWhenTwoOffencesAreSaved_CountIsTwo() {
        assertEquals(0L,offenceRepository.count());
        Offence offenceOne = new Offence();
        Offence offenceTwo = new Offence();
        offenceRepository.save(offenceOne);
        offenceRepository.save(offenceTwo);
        assertEquals(2L,offenceRepository.count());
    }

    @Test
    public void testThatWhenIFindById_OffenceIsFound() {
        offence.setId("1");
        offenceRepository.save(offence);
        assertEquals(offence,offenceRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        offence.setId("1");
        offenceRepository.save(offence);
        assertThrows(IllegalArgumentException.class, () -> offenceRepository.findById("6"));
    }

    @Test
    public void testThatWhenIDeleteOffenceWithId_OffenceIsDeletedAndCountIsZero() {
        offence.setId("1");
        offenceRepository.save(offence);
        assertEquals(1L,offenceRepository.count());
        offenceRepository.del("1");
        assertEquals(0L,offenceRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoOffences_andDeleteAllCountIsZero(){
        assertEquals(0L,offenceRepository.count());
        Offence offenceOne = new Offence();
        Offence offenceTwo = new Offence();
        offenceRepository.save(offenceOne);
        offenceRepository.save(offenceTwo);
        offenceRepository.deleteAll();
        assertEquals(0L,offenceRepository.count());
    }

    @Test
    public void testThatIfOffenceIdExists_ItIsTrue(){
        offence.setId("1");
        offenceRepository.save(offence);
        assertTrue(offenceRepository.existsById("1"));
    }

    @Test
    public void testThatIfOffenceIdDoesNotExist_ItIsFalse(){
        offence.setId("1");
        offenceRepository.save(offence);
        assertFalse(offenceRepository.existsById("2"));
    }

    @Test
    public void testThatIGetAllOffencesWhenIFindAll(){
        assertEquals(0L,offenceRepository.count());
        Offence offenceOne = new Offence();
        Offence offenceTwo = new Offence();
        offenceRepository.save(offenceOne);
        offenceRepository.save(offenceTwo);

        List<Offence> offences = offenceRepository.findAll();
        assertEquals(2L, offences.size());
    }
}