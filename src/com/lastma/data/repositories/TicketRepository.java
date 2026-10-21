package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.List;

public interface TicketRepository {
    long count();

    void save(Ticket ticket);

    Ticket findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Ticket> findAll();
}
