package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.List;

public interface OfficerRepository {
    long count();

    void save(Officer officer);

    Officer findById(int id);

    void del(int id);

    void deleteAll();

    boolean existsById(int id);

    List<Officer> findAll();
}
