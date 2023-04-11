package com.nashss.se.musicplaylistservice.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TicketDaoTest {

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private TicketDao ticketDao;

    @BeforeEach
    public void setup() {
        initMocks(this);
        ticketDao = new TicketDao(dynamoDBMapper);
    }

    @Test
    void getTicket_withNonexistentProjectIdAndTicketId_loadsTicketByPartitionAndSortKeys() {
        // GIVEN
        String projectId = "projectId";
        String ticketId = "ticketId";
        Ticket ticket = new Ticket();
        ticket.setProjectId(projectId);
        ticket.setTicketId(ticketId);
        when(dynamoDBMapper.load(Ticket.class, projectId, ticketId)).thenReturn(ticket);

        // WHEN
        Ticket result = ticketDao.getTicket(projectId, ticketId);

        // THEN
        verify(dynamoDBMapper).load(Ticket.class, projectId, ticketId);
        assertEquals(ticket, result,
                String.format("Expected to receive Ticket returned by DDB (%s), but received %s",
                        ticket,
                        result)
        );
    }
}
