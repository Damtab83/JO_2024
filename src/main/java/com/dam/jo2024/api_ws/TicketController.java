package com.dam.jo2024.api_ws;

import com.dam.jo2024.pojo.Ticket;
import com.dam.jo2024.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Displaying CRUD of the Tickets for the API
@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_TICKET)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Object>getAllTicket() {
        List<Ticket>tickets = ticketService.getAllTickets();
        return  ResponseEntity.status(HttpStatus.OK).body(tickets);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object>getTicketById(@PathVariable Long id) {
        Ticket myTicket = ticketService.getTicketById(id);
        return myTicket == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myTicket);
    }

    @PostMapping
    public ResponseEntity<Object> createTicket(@RequestBody Ticket myTicket) {
        ticketService.createTicket(myTicket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteTicket(@PathVariable Long id) {
        Boolean isDelete = ticketService.deleteTicket(id);
        return isDelete ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
