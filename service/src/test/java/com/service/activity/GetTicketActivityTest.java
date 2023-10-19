package com.service.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.service.activity.requests.GetTicketRequest;
import com.service.activity.results.GetTicketResult;
import com.service.dynamodb.TicketDao;
import com.service.dynamodb.models.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GetTicketActivityTest {

    @Mock
    private TicketDao ticketDao;

    private GetTicketActivity getTicketActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        this.getTicketActivity = new GetTicketActivity(ticketDao);
    }

    @Test
    public void handleRequest_savedTicketFound_returnsTicketModelInResult() {
        // GIVEN
        String ticketId = "expectedId";
        String projectId = "expectedId";
        String expectedTitle = "expectedTitle";
        String expectedDescription = "expectedDescription";
        String expectedStatus = "expectedStatus";

        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);
        ticket.setProjectId(projectId);
        ticket.setTitle(expectedTitle);
        ticket.setDescription(expectedDescription);
        ticket.setStatus(expectedStatus);

        when(ticketDao.getTicket(ticketId, projectId)).thenReturn(ticket);

        GetTicketRequest ticketRequest = new GetTicketRequest.Builder()
            .withTicketId(ticketId).withProjectId(projectId)
            .build();

        // WHEN
        GetTicketResult result = getTicketActivity.handleRequest(ticketRequest);

        // THEN
        Assertions.assertEquals(ticketId, result.getTicketModel().getTicketId());
        Assertions.assertEquals(projectId, result.getTicketModel().getProjectId());
        Assertions.assertEquals(expectedTitle, result.getTicketModel().getTitle());
        Assertions.assertEquals(expectedDescription, result.getTicketModel().getDescription());
        Assertions.assertEquals(expectedStatus, result.getTicketModel().getStatus());
    }
}
