package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateTicketResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import com.nashss.se.musicplaylistservice.utils.TicketIdGenerator;
import com.nashss.se.projectresources.music.playlist.servic.util.MusicPlaylistServiceUtils;
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

        if (!MusicPlaylistServiceUtils.isValidString(createTicketRequest.getTitle())) {
            throw new InvalidAttributeValueException("Ticket title [" + createTicketRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!MusicPlaylistServiceUtils.isValidString(createTicketRequest.getDescription())) {
            throw new InvalidAttributeValueException("Playlist customer ID [" + createTicketRequest.getDescription() +
                    "] contains illegal characters");
        }

        Ticket newTicket = new Ticket();
        newTicket.setProjectId(createTicketRequest.getProjectId());
        newTicket.setTicketId(TicketIdGenerator.generateTicketId());
        newTicket.setTitle(createTicketRequest.getTitle());
        newTicket.setDescription(createTicketRequest.getDescription());
        newTicket.setStatus(createTicketRequest.getStatus());

        ticketDao.saveTicket(newTicket);

        TicketModel ticketModel = new ProjectModelConverter().toTicketModel(newTicket);
        return CreateTicketResult.builder()
                .withTicketModel(ticketModel)
                .build();
    }

}
