package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.List;

public interface OfficerRepository {
    long count();

    void save(Officer officer);

    Officer findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Officer> findAll();
}
