package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.utils.TicketManagementServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UpdateTicketResult handleRequest(UpdateTicketRequest updateTicketRequest) {
        log.info("Received UpdatePlaylistRequest {}", updateTicketRequest);

        if (!TicketManagementServiceUtils.isValidString(updateTicketRequest.getTitle())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!TicketManagementServiceUtils.isValidString(updateTicketRequest.getDescription())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketRequest.getDescription() +
                    "] contains illegal characters");
        }

        Ticket ticket = ticketDao.getTicket(updateTicketRequest.getProjectId(), updateTicketRequest.getTicketId());


        ticket.setTitle(updateTicketRequest.getTitle());
        ticket.setDescription(updateTicketRequest.getDescription());
        ticket.setStatus(updateTicketRequest.getStatus());
        ticket = ticketDao.saveTicket(ticket);

        return UpdateTicketResult.builder()
                .withTicketModel(new ProjectModelConverter().toTicketModel(ticket))
                .build();
    }
}