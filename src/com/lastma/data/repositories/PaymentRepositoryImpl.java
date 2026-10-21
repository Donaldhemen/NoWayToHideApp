package com.lastma.data.repositories;

import com.lastma.data.models.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    private static List<Payment> payments = new ArrayList<>();

    @Override
    public long count() {
        return payments.size();
    }

    @Override
    public void save(Payment payment) {
        payments.add(payment);
    }

    @Override
    public Payment findById(String id) {
        for(Payment forEachPaymentIn : payments){
            if(forEachPaymentIn.getId().equals(id)){
                return forEachPaymentIn;
            }
        }
        throw new IllegalArgumentException("Payment with id " + id + " not found");
    }

    @Override
    public void deleteById(String id) {
        for(Payment payment : payments){
            if(payment.getId().equals(id)){
                payments.remove(payment);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        payments.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Payment forEachPaymentIn : payments){
            if(forEachPaymentIn.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return List.copyOf(payments);
    }
}
