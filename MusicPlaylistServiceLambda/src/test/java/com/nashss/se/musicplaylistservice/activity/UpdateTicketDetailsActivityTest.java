package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketDetailsRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketDetailsResult;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UpdateTicketDetailsActivityTest {
    @Mock
    private TicketDao ticketDao;

    private UpdateTicketDetailsActivity updateTicketDetailsActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        updateTicketDetailsActivity = new UpdateTicketDetailsActivity(ticketDao);
    }

    @Test
    public void handleRequest_goodRequest_updatesTicketName() {
        // GIVEN
        String projectId = "My-project";
        String ticketId = "123456";
        String ticketTitle = "ticketTitle";
        String ticketDescription = "ticketDescription";
        String ticketStatus = "ticketStatus";

        UpdateTicketDetailsRequest request = UpdateTicketDetailsRequest.builder()
                .withTicketId(ticketId)
                .withProjectId(projectId)
                .withTitle(ticketTitle)
                .withDescription(ticketDescription)
                .withStatus(ticketStatus)
                .build();

        Ticket startingTicket = new Ticket();
        startingTicket.setTicketId(ticketId);
        startingTicket.setProjectId(projectId);
        startingTicket.setTitle("old title");
        startingTicket.setDescription("old description");
        startingTicket.setStatus("old status");

        when(ticketDao.getTicket(projectId, ticketId)).thenReturn(startingTicket);
        when(ticketDao.saveTicket(startingTicket)).thenReturn(startingTicket);

        // WHEN
        UpdateTicketDetailsResult result = updateTicketDetailsActivity.handleRequest(request);

        // THEN
        assertEquals(projectId, result.getTicketModel().getProjectId());
        assertEquals(ticketId, result.getTicketModel().getTicketId());
        assertEquals(ticketTitle, result.getTicketModel().getTitle());
        assertEquals(ticketDescription, result.getTicketModel().getDescription());
        assertEquals(ticketStatus, result.getTicketModel().getStatus());
    }

    @Test
    public void handleRequest_invalidTitle_throwsInvalidAttributeValueException() {
        // GIVEN
        String projectId = "My-project";
        String ticketId = "123456";
        String ticketDescription = "ticketDescription";
        String ticketStatus = "ticketStatus";

        UpdateTicketDetailsRequest request = UpdateTicketDetailsRequest.builder()
                .withTicketId(ticketId)
                .withProjectId(projectId)
                .withTitle("'/badTicketTitle/'")
                .withDescription(ticketDescription)
                .withStatus(ticketStatus)
                .build();

        // WHEN + THEN
        assertThrows(InvalidAttributeValueException.class, () -> updateTicketDetailsActivity.handleRequest(request));
    }


}
