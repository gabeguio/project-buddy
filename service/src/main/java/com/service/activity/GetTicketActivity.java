package com.service.activity;

import javax.inject.Inject;

import com.service.activity.requests.GetTicketRequest;
import com.service.activity.results.GetTicketResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.TicketDao;
import com.service.dynamodb.models.Ticket;
import com.service.models.TicketModel;
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

        return GetTicketResult.builder().withTicket(ticketModel).build();
    }
}
