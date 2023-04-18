package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketStatusRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketStatusResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;

import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;
import com.nashss.se.musicplaylistservice.metrics.MetricsConstants;

import com.nashss.se.musicplaylistservice.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class UpdateTicketStatusActivity {

    private final Logger log = LogManager.getLogger();

    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketStatusActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UpdateTicketStatusResult handleRequest(final UpdateTicketStatusRequest updateTicketStatusRequest){
        log.info("Received UpdateTicketStatusRequest{}", updateTicketStatusRequest);

        Ticket ticket = ticketDao.getTicket(updateTicketStatusRequest.getProjectId(), updateTicketStatusRequest.getTicketId());

        ticket.setStatus(updateTicketStatusRequest.getStatus());
        ticket = ticketDao.saveTicket(ticket);

        return UpdateTicketStatusResult.builder().withTicket(new ProjectModelConverter().toTicketModel(ticket))
                .build();
    }
}
