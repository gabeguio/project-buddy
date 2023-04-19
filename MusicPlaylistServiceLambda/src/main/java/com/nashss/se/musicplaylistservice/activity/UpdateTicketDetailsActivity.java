package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketDetailsRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketDetailsResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.utils.TicketManagementServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateTicketDetailsActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketDetailsActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UpdateTicketDetailsResult handleRequest(UpdateTicketDetailsRequest updateTicketDetailsRequest) {
        log.info("Received UpdatePlaylistRequest {}", updateTicketDetailsRequest);

        if (!TicketManagementServiceUtils.isValidString(updateTicketDetailsRequest.getTitle())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketDetailsRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!TicketManagementServiceUtils.isValidString(updateTicketDetailsRequest.getDescription())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketDetailsRequest.getDescription() +
                    "] contains illegal characters");
        }

        Ticket ticket = ticketDao.getTicket(updateTicketDetailsRequest.getProjectId(), updateTicketDetailsRequest.getTicketId());


        ticket.setTitle(updateTicketDetailsRequest.getTitle());
        ticket.setDescription(updateTicketDetailsRequest.getDescription());
        ticket.setStatus(updateTicketDetailsRequest.getStatus());
        ticket = ticketDao.saveTicket(ticket);

        return UpdateTicketDetailsResult.builder()
                .withTicketModel(new ProjectModelConverter().toTicketModel(ticket))
                .build();
    }
}