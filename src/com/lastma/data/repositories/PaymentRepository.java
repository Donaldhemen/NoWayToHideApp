package com.lastma.data.repositories;

import com.lastma.data.models.Payment;

import java.util.List;

public interface PaymentRepository {
    long count();

    void save(Payment ticket);

    Payment findById(String id);

    void deleteById(String id);

    void deleteAll();

    boolean existsById(String id);

    List<Payment> findAll();
}
