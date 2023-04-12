package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }


}
