package com.example.ha_web_deployment_2.controller;

import com.example.ha_web_deployment_2.models.Ticket;
import com.example.ha_web_deployment_2.repository.TicketRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController extends GenericController<Ticket> {

    public TicketController(TicketRepository ticketRepository) {
        super(ticketRepository);
    }
}