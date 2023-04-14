package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    public DeleteTicketActivity(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    public void handleRequest(String ticketId, String projectId){
        log.info("Received request to delete ticket with id {}", ticketId);
        Ticket ticket = ticketDao.getTicket(projectId, ticketId);
        ticketDao.deleteTicket(ticket);
    }
}
