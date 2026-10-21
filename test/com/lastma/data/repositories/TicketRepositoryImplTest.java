package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryImplTest {
    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;

    @BeforeEach
    void setup() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();
    }

    @Test
    public void testThatWhenISaveTicket_CountIsOne() {
        assertEquals(0L,ticketRepository.count());
        ticketRepository.save(ticket);
        assertEquals(1L,ticketRepository.count());
    }

    @Test
    public void testThatWhenTwoTicketsAreSaved_CountIsTwo() {
        assertEquals(0L,ticketRepository.count());
        Ticket ticketOne = new Ticket();
        Ticket ticketTwo = new Ticket();
        ticketRepository.save(ticketOne);
        ticketRepository.save(ticketTwo);
        assertEquals(2L,ticketRepository.count());
    }

    @Test
    public void testThatWhenIFindById_TicketIsFound() {
        ticket.setId("1");
        ticketRepository.save(ticket);
        assertEquals(ticket,ticketRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        ticket.setId("1");
        ticketRepository.save(ticket);
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findById("6"));
    }

    @Test
    public void testThatWhenIDeleteTicketWithId_TicketIsDeletedAndCountIsZero() {
        ticket.setId("1");
        ticketRepository.save(ticket);
        assertEquals(1L,ticketRepository.count());
        ticketRepository.deleteById("1");
        assertEquals(0L,ticketRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoTickets_andDeleteAllCountIsZero(){
        assertEquals(0L,ticketRepository.count());
        Ticket ticketOne = new Ticket();
        Ticket ticketTwo = new Ticket();
        ticketRepository.save(ticketOne);
        ticketRepository.save(ticketTwo);
        ticketRepository.deleteAll();
        assertEquals(0L,ticketRepository.count());
    }

    @Test
    public void testThatIfTicketIdExists_ItIsTrue(){
        ticket.setId("1");
        ticketRepository.save(ticket);
        assertTrue(ticketRepository.existsById("1"));
    }

    @Test
    public void testThatIfTicketIdDoesNotExist_ItIsFalse(){
        ticket.setId("1");
        ticketRepository.save(ticket);
        assertFalse(ticketRepository.existsById("2"));
    }

    @Test
    public void testThatIGetAllTicketsWhenIFindAll(){
        assertEquals(0L,ticketRepository.count());
        Ticket ticketOne = new Ticket();
        Ticket ticketTwo = new Ticket();
        ticketRepository.save(ticketOne);
        ticketRepository.save(ticketTwo);

        List<Ticket> tickets = ticketRepository.findAll();
        assertEquals(2L, tickets.size());
    }
}