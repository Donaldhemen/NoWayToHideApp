package com.lastma.data.repositories;

import com.lastma.data.models.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryImplTest {
    private PaymentRepositoryImpl paymentRepository;
    private Payment payment;

    @BeforeEach
    void setup() {
        paymentRepository = new PaymentRepositoryImpl();
        payment = new Payment();
    }

    @Test
    public void testThatWhenISavePayment_CountIsOne() {
        assertEquals(0L,paymentRepository.count());
        paymentRepository.save(payment);
        assertEquals(1L,paymentRepository.count());
    }

    @Test
    public void testThatWhenTwoPaymentsAreSaved_CountIsTwo() {
        assertEquals(0L,paymentRepository.count());
        Payment paymentOne = new Payment();
        Payment paymentTwo = new Payment();
        paymentRepository.save(paymentOne);
        paymentRepository.save(paymentTwo);
        assertEquals(2L,paymentRepository.count());
    }

    @Test
    public void testThatWhenIFindById_PaymentIsFound() {
        payment.setId("1");
        paymentRepository.save(payment);
        assertEquals(payment,paymentRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        payment.setId("1");
        paymentRepository.save(payment);
        assertThrows(IllegalArgumentException.class, () -> paymentRepository.findById("6"));
    }

    @Test
    public void testThatWhenIDeletePaymentWithId_PaymentIsDeletedAndCountIsZero() {
        payment.setId("1");
        paymentRepository.save(payment);
        assertEquals(1L,paymentRepository.count());
        paymentRepository.del("1");
        assertEquals(0L,paymentRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoPayments_andDeleteAllCountIsZero(){
        assertEquals(0L,paymentRepository.count());
        Payment paymentOne = new Payment();
        Payment paymentTwo = new Payment();
        paymentRepository.save(paymentOne);
        paymentRepository.save(paymentTwo);
        paymentRepository.deleteAll();
        assertEquals(0L,paymentRepository.count());
    }

    @Test
    public void testThatIfPaymentIdExists_ItIsTrue(){
        payment.setId("1");
        paymentRepository.save(payment);
        assertTrue(paymentRepository.existsById("1"));
    }

    @Test
    public void testThatIfPaymentIdDoesNotExist_ItIsFalse(){
        payment.setId("1");
        paymentRepository.save(payment);
        assertFalse(paymentRepository.existsById("2"));
    }

    @Test
    public void testThatIGetAllPaymentsWhenIFindAll(){
        assertEquals(0L,paymentRepository.count());
        Payment paymentOne = new Payment();
        Payment paymentTwo = new Payment();
        paymentRepository.save(paymentOne);
        paymentRepository.save(paymentTwo);

        List<Payment> payments = paymentRepository.findAll();
        assertEquals(2L, payments.size());
    }
}