package com.nashss.se.musicplaylistservice.dynamodb;

import javax.inject.Inject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;

public class TicketDao {
    private final DynamoDBMapper dynamoDBMapper;
    @Inject
    public TicketDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Ticket getTicket(String projectId, String ticketId) {
        Ticket ticket = this.dynamoDBMapper.load(Ticket.class, projectId, ticketId);

        return ticket;
    }

    public Ticket saveTicket(Ticket ticket) {
        this.dynamoDBMapper.save(ticket);
        return ticket;
    }
}
