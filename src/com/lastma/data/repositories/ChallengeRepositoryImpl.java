package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;

import java.util.ArrayList;
import java.util.List;

public class ChallengeRepositoryImpl implements ChallengeRepository {
    private static List<Challenge> challenges = new ArrayList<>();

    @Override
    public long count() {
        return challenges.size();
    }

    @Override
    public void save(Challenge challenge) {
        challenges.add(challenge);
    }

    @Override
    public Challenge findById(String id) {
        for(Challenge forEachChallengeIn : challenges){
            if(forEachChallengeIn.getId().equals(id)){
                return forEachChallengeIn;
            }
        }
        throw new IllegalArgumentException("Challenge with id " + id + " not found");
    }

    @Override
    public void deleteById(String id) {
        for(Challenge challenge : challenges){
            if(challenge.getId().equals(id)){
                challenges.remove(challenge);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        challenges.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Challenge forEachChallengeIn : challenges){
            if(forEachChallengeIn.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Challenge> findAll() {
        return List.copyOf(challenges);
    }
}
