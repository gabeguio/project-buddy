package com.service.activity;

import com.service.activity.requests.CreateTicketRequest;
import com.service.activity.results.CreateTicketResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.TicketDao;
import com.service.dynamodb.models.Ticket;
import com.service.exceptions.InvalidAttributeValueException;
import com.service.models.TicketModel;
import com.service.utils.ProjectManagementServiceUtils;
import com.service.utils.TicketIdGenerator;
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
