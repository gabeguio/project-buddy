package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.DeleteTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteTicketResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;
    @Inject
    public DeleteTicketActivity(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    public DeleteTicketResult handleRequest(DeleteTicketRequest request){
        log.info("Received request to delete ticket with request {}", request);
        Ticket ticket = new Ticket();
        ticket.setTicketId(request.getTicketId());
        ticket.setProjectId(request.getProjectId());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setTitle(request.getTitle());

        ticketDao.deleteTicket(ticket);
        TicketModel ticketModel = new ProjectModelConverter().toTicketModel(ticket);

        return DeleteTicketResult.builder().withTicket(ticketModel).build();
    }
}
