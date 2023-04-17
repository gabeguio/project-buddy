package com.nashss.se.musicplaylistservice.activity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.nashss.se.musicplaylistservice.activity.requests.GetAllTicketsRequest;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.TicketNotFoundException;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import com.nashss.se.musicplaylistservice.test.helper.TicketTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GetAllTicketsActivityTest {
    @Mock
    private TicketDao ticketDao;

    private GetAllTicketsActivity getAllTicketsActivity;

    @BeforeEach
    void setup() {
        openMocks(this);
        getAllTicketsActivity = new GetAllTicketsActivity(ticketDao);
    }

    @Test
    void handleRequest_ticketExists_returnsTicket() {
        // GIVEN
       Ticket ticket = TicketTestHelper.generateTicket();
       Ticket ticket2 = TicketTestHelper.generateTicket();

       List<Ticket> ticketList = new ArrayList<>();
       ticketList.add(ticket);
       ticketList.add(ticket2);

        GetAllTicketsRequest request = GetAllTicketsRequest.builder()
            .withId("projectId")
            .build();
        when(ticketDao.getAllTicketsForProjectId("projectId")).thenReturn(ticketList);

        // WHEN
        List<TicketModel> returnedTickets = getAllTicketsActivity.handleRequest(request).getTicketList();

        // THEN
        Assertions.assertTrue(TicketTestHelper.AssertTicketModelEquals(ticketList, returnedTickets));
    }




    @Test
    public void handleRequest_noMatchingProjectId_throwsTicketNotFoundException() {
        // GIVEN
        String projectId = "missingID";
        GetAllTicketsRequest request = GetAllTicketsRequest.builder()
            .withId(projectId)
            .build();

        // WHEN
        when(ticketDao.getAllTicketsForProjectId(projectId)).thenThrow(new TicketNotFoundException());

        // WHEN + THEN
        assertThrows(TicketNotFoundException.class, () -> getAllTicketsActivity.handleRequest(request));
    }
}
