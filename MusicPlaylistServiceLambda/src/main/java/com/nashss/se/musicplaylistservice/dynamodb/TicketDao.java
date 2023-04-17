package com.nashss.se.musicplaylistservice.dynamodb;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.TicketNotFoundException;

import javax.inject.Inject;

public class TicketDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public TicketDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Ticket getTicket(String projectId, String ticketId) {
        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }

        Ticket ticket = this.dynamoDBMapper.load(Ticket.class, projectId, ticketId);

        if(ticket == null) {
            throw new TicketNotFoundException("ticket not found for requested projectId");
        }

        return ticket;
    }

    public void saveTicket(Ticket ticket) {
        this.dynamoDBMapper.save(ticket);
    }

    public List<Ticket> getAllTicketsForProjectId(String projectId) {

        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":projectId", new AttributeValue().withS(projectId));

        DynamoDBQueryExpression<Ticket> queryExpression = new DynamoDBQueryExpression<Ticket>()
            .withKeyConditionExpression("projectId = :projectId")
            .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Ticket> ticketList = dynamoDBMapper.query(Ticket.class, queryExpression);

        if(ticketList == null) {
            throw new TicketNotFoundException("tickets not found for requested projectId");
        }

        return ticketList;
    }
}
