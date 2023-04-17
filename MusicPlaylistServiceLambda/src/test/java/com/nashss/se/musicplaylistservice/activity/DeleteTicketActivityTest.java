package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.DeleteTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteTicketResult;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DeleteTicketActivityTest {

    @Mock
    private TicketDao ticketDao;
    private DeleteTicketActivity deleteTicketActivity;

    @BeforeEach
    public void setup(){
        initMocks(this);
        deleteTicketActivity = new DeleteTicketActivity(ticketDao);
    }

    @Test
    public void handleRequest_withTicketIdAndProjectId_deletesTicket(){
        // Given
        DeleteTicketRequest request = DeleteTicketRequest.builder()
                .withTicketId("123")
                .withProjectId("456")
                .withTitle("Ticket Title")
                .withDescription("Ticket Description")
                .withStatus("open")
                .build();

        Ticket ticket = new Ticket();
        ticket.setTicketId(request.getTicketId());
        ticket.setProjectId(request.getProjectId());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setTitle(request.getTitle());

        // When
        DeleteTicketResult result = deleteTicketActivity.handleRequest(request);

        // Then
        verify(ticketDao).deleteTicket(ticket);

        TicketModel ticketModel = result.getTicket();
        assertEquals(request.getTicketId(), ticketModel.getTicketId());
        assertEquals(request.getProjectId(), ticketModel.getProjectId());
        assertEquals(request.getTitle(), ticketModel.getTitle());
        assertEquals(request.getDescription(), ticketModel.getDescription());
        assertEquals(request.getStatus(), ticketModel.getStatus());
    }
}
