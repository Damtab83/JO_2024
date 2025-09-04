package com.dam.jo2024.services;

import com.dam.jo2024.pojo.Ticket;
import com.dam.jo2024.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket>getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {

        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        LocalDateTime myDate = LocalDateTime.now();
        ticket.setDateCreation(myDate);

        ticket.setTicketKey(keyAuth(ticket));
        return ticketRepository.save(ticket);
    }

    public Boolean deleteTicket(Long id) {

        Boolean toDelete = ticketRepository.existsById(id);
        if(toDelete) {
            ticketRepository.deleteById(id);
        }
        return toDelete;
    }

    public String keyAuth(Ticket ticket) {

        DateTimeFormatter myDateformat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String keyAuth = ticket.getDateCreation().format(myDateformat);
        return keyAuth;
    }

}
