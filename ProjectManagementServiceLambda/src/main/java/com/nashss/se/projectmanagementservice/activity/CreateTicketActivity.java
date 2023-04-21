package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.CreateTicketRequest;
import com.nashss.se.projectmanagementservice.activity.results.CreateTicketResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.TicketDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;
import com.nashss.se.projectmanagementservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.projectmanagementservice.models.TicketModel;
import com.nashss.se.projectmanagementservice.utils.ProjectManagementServiceUtils;
import com.nashss.se.projectmanagementservice.utils.TicketIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public CreateTicketActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public CreateTicketResult handleRequest(final CreateTicketRequest createTicketRequest) {
        log.info("Received CreateTicketRequest {}", createTicketRequest);

        if (!ProjectManagementServiceUtils.isValidString(createTicketRequest.getTitle())) {
            throw new InvalidAttributeValueException("Ticket title [" + createTicketRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!ProjectManagementServiceUtils.isValidString(createTicketRequest.getDescription())) {
            throw new InvalidAttributeValueException("Playlist customer ID [" + createTicketRequest.getDescription() +
                    "] contains illegal characters");
        }

        Ticket newTicket = new Ticket();
        newTicket.setProjectId(createTicketRequest.getProjectId());
        newTicket.setTicketId(TicketIdGenerator.generateTicketId());
        newTicket.setTitle(createTicketRequest.getTitle());
        newTicket.setDescription(createTicketRequest.getDescription());
        newTicket.setStatus(createTicketRequest.getStatus());

        ticketDao.saveTicket(newTicket);

        TicketModel ticketModel = new ProjectModelConverter().toTicketModel(newTicket);
        return CreateTicketResult.builder()
                .withTicketModel(ticketModel)
                .build();
    }

}
