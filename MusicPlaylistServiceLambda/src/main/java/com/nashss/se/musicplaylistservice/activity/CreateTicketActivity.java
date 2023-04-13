package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateTicketResult;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public CreateTicketActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }


    public CreateTicketResult handleRequest(final CreateTicketRequest createTicketRequest) {
        log.info("Received CreateTicketRequest {}", createTicketRequest);


    }

}
