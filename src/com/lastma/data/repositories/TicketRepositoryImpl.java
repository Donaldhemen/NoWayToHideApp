package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public long count() {
        return tickets.size();
    }

    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public Ticket findById(String id) {
        for(Ticket forEachTicketIn : tickets){
            if(forEachTicketIn.getId() == id){
                return forEachTicketIn;
            }
        }
        throw new IllegalArgumentException("Ticket with id " + id + " not found");
    }

    @Override
    public void del(String id) {
        for(Ticket ticket : tickets){
            if(ticket.getId() == id){
                tickets.remove(ticket);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Ticket forEachTicketIn : tickets){
            if(id.equals(forEachTicketIn.getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Ticket> findAll() {
        return List.copyOf(tickets);
    }
}
