package com.service.activity;

import com.service.activity.requests.DeleteTicketRequest;
import com.service.activity.results.DeleteTicketResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.TicketDao;
import com.service.dynamodb.models.Ticket;
import com.service.models.TicketModel;
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

        ticketDao.deleteTicket(ticket);
        TicketModel ticketModel = new ProjectModelConverter().toTicketModel(ticket);

        return DeleteTicketResult.builder().withTicket(ticketModel).build();
    }
}
