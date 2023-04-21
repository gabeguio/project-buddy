package com.nashss.se.projectmanagementservice.activity;

import javax.inject.Inject;

import com.nashss.se.projectmanagementservice.activity.requests.GetTicketRequest;
import com.nashss.se.projectmanagementservice.activity.results.GetTicketResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.TicketDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;
import com.nashss.se.projectmanagementservice.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public GetTicketActivity(TicketDao ticketDao) {this.ticketDao = ticketDao;}


    public GetTicketResult handleRequest(final GetTicketRequest getTicketRequest) {
        log.info("Received GetTicketRequest {}", getTicketRequest);
        String projectId = getTicketRequest.getProjectId();
        String ticketId = getTicketRequest.getTicketId();
        Ticket ticket = ticketDao.getTicket(projectId, ticketId);
        TicketModel ticketModel = new ProjectModelConverter().toTicketModel(ticket);

        return GetTicketResult.builder()
            .withTicket(ticketModel)
            .build();
    }
}
