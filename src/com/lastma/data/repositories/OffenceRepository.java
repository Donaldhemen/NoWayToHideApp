package com.lastma.data.repositories;

import com.lastma.data.models.Offence;

import java.util.List;

public interface OffenceRepository {
    long count();

    void save(Offence ticket);

    Offence findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Offence> findAll();
}
