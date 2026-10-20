package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeRepositoryImplTest {
    private ChallengeRepositoryImpl challengeRepository;
    private Challenge challenge;

    @BeforeEach
    void setup() {
        challengeRepository = new ChallengeRepositoryImpl();
        challenge = new Challenge();
    }

    @Test
    public void testThatWhenISaveChallenge_CountIsOne() {
        assertEquals(0L,challengeRepository.count());
        challengeRepository.save(challenge);
        assertEquals(1L,challengeRepository.count());
    }

    @Test
    public void testThatWhenTwoChallengesAreSaved_CountIsTwo() {
        assertEquals(0L,challengeRepository.count());
        Challenge challengeOne = new Challenge();
        Challenge challengeTwo = new Challenge();
        challengeRepository.save(challengeOne);
        challengeRepository.save(challengeTwo);
        assertEquals(2L,challengeRepository.count());
    }

    @Test
    public void testThatWhenIFindById_ChallengeIsFound() {
        challenge.setId("1");
        challengeRepository.save(challenge);
        assertEquals(challenge,challengeRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        challenge.setId("1");
        challengeRepository.save(challenge);
        assertThrows(IllegalArgumentException.class, () -> challengeRepository.findById("6"));
    }

    @Test
    public void testThatWhenIDeleteChallengeWithId_ChallengeIsDeletedAndCountIsZero() {
        challenge.setId("1");
        challengeRepository.save(challenge);
        assertEquals(1L,challengeRepository.count());
        challengeRepository.del("1");
        assertEquals(0L,challengeRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoChallenges_andDeleteAllCountIsZero(){
        assertEquals(0L,challengeRepository.count());
        Challenge challengeOne = new Challenge();
        Challenge challengeTwo = new Challenge();
        challengeRepository.save(challengeOne);
        challengeRepository.save(challengeTwo);
        challengeRepository.deleteAll();
        assertEquals(0L,challengeRepository.count());
    }

    @Test
    public void testThatIfChallengeIdExists_ItIsTrue(){
        challenge.setId("1");
        challengeRepository.save(challenge);
        assertTrue(challengeRepository.existsById("1"));
    }

    @Test
    public void testThatIfChallengeIdDoesNotExist_ItIsFalse(){
        challenge.setId("1");
        challengeRepository.save(challenge);
        assertFalse(challengeRepository.existsById("2"));
    }

    @Test
    public void testThatIGetAllChallengesWhenIFindAll(){
        assertEquals(0L,challengeRepository.count());
        Challenge challengeOne = new Challenge();
        Challenge challengeTwo = new Challenge();
        challengeRepository.save(challengeOne);
        challengeRepository.save(challengeTwo);

        List<Challenge> challenges = challengeRepository.findAll();
        assertEquals(2L, challenges.size());
    }
}