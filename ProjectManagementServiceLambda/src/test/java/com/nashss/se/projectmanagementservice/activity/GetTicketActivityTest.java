package com.nashss.se.projectmanagementservice.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.nashss.se.projectmanagementservice.activity.requests.GetTicketRequest;
import com.nashss.se.projectmanagementservice.activity.results.GetTicketResult;
import com.nashss.se.projectmanagementservice.dynamodb.TicketDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;
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
            .withId(ticketId, projectId)
            .build();

        // WHEN
        GetTicketResult result = getTicketActivity.handleRequest(ticketRequest);

        // THEN
        assertEquals(ticketId, result.getTicketModel().getTicketId());
        assertEquals(projectId, result.getTicketModel().getProjectId());
        assertEquals(expectedTitle, result.getTicketModel().getTitle());
        assertEquals(expectedDescription, result.getTicketModel().getDescription());
        assertEquals(expectedStatus, result.getTicketModel().getStatus());
    }
}
