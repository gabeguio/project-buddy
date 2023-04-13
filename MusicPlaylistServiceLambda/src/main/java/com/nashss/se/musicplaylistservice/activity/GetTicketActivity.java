package com.nashss.se.musicplaylistservice.activity;

import javax.inject.Inject;

import com.nashss.se.musicplaylistservice.activity.requests.GetPlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetPlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.GetTicketResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.models.PlaylistModel;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTicketActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public GetTicketActivity(TicketDao ticketDao) {this.ticketDao = ticketDao;}


    public GetTicketResult handleRequest(final GetTicketRequest getTicketRequest) {
        log.info("Received GetTicketRequest {}", getTicketRequest);
        String projectId = getTicketRequest.getProjectId();
        String ticketId = getTicketRequest.getTicketId();
        Ticket ticket = ticketDao.getTicket(projectId, ticketId);
       TicketModel ticketModel = new ProjectModelConverter().toTicketModel(ticket);

        return GetTicketResult.builder()
            .withTicket(ticketModel)
            .build();
    }
}
