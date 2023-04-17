package com.nashss.se.musicplaylistservice.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;

import javax.inject.Inject;

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

    public void deleteTicket(Ticket ticket){
        this.dynamoDBMapper.delete(ticket);
    }
}
