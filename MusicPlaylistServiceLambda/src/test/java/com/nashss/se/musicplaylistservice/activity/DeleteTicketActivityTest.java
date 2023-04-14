package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
        //GIVEN
        String projectId = "expectedId";
        String ticketId = "expectedTicketId";
        Ticket ticketToBeDeleted = new Ticket();
        when(ticketDao.getTicket(projectId,ticketId)).thenReturn(ticketToBeDeleted);

        //WHEN
        deleteTicketActivity.handleRequest(ticketId,projectId);

        //THEN
        verify(ticketDao).deleteTicket(ticketToBeDeleted);
    }
}
