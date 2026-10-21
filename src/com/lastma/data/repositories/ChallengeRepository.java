package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;

import java.util.List;

public interface ChallengeRepository {
    long count();

    void save(Challenge ticket);

    Challenge findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Challenge> findAll();
}

