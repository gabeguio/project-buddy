package com.service.activity;

import com.service.activity.requests.UpdateTicketStatusRequest;
import com.service.activity.results.UpdateTicketStatusResult;
import com.service.dynamodb.TicketDao;
import com.service.dynamodb.models.Ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.mockito.InjectMocks;

public class UpdateTicketStatusActivityTest {

    @Mock
    private TicketDao ticketDao;

    @InjectMocks
    private UpdateTicketStatusActivity updateTicketStatusActivity;

    @BeforeEach
    public void setup() {
        openMocks(this);
        updateTicketStatusActivity = new UpdateTicketStatusActivity(ticketDao);
    }

    @Test
    public void testHandleRequest() {
        // given
        String projectId = "project-123";
        String ticketId = "ticket-123";
        String oldStatus = "completed";
        String expectedStatus = "in-progress";

        UpdateTicketStatusRequest request = UpdateTicketStatusRequest.builder()
                .withStatus(expectedStatus)
                .withTicketId(ticketId)
                .withProjectId(projectId)
                .build();

        Ticket ticket = new Ticket();
        ticket.setProjectId(projectId);
        ticket.setTicketId(ticketId);
        ticket.setStatus(oldStatus);

        when(ticketDao.getTicket(projectId, ticketId)).thenReturn(ticket);
        when(ticketDao.saveTicket(ticket)).thenReturn(ticket);


        // when
        UpdateTicketStatusResult result = updateTicketStatusActivity.handleRequest(request);

        // then
        assertEquals(ticketId, result.getTicket().getTicketId());
        assertEquals(projectId, result.getTicket().getProjectId());
        assertEquals(expectedStatus, result.getTicket().getStatus());

    }
}
