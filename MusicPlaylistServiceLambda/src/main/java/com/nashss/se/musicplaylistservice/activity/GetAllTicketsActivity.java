package com.nashss.se.musicplaylistservice.activity;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.nashss.se.musicplaylistservice.activity.requests.GetAllTicketsRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetPlaylistSongsRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetAllTicketsResult;
import com.nashss.se.musicplaylistservice.activity.results.GetPlaylistSongsResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.PlaylistDao;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.SongOrder;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAllTicketsActivity {
    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    /**
     * Instantiates a new GetPlaylistSongsActivity object.
     *
     * @param ticketDao TicketDao to access the tickets table.
     */
    @Inject
    public GetAllTicketsActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    /**
     * This method handles the incoming request by retrieving the tickets from the database.
     * <p>
     * It then returns the tickets list.
     * <p>
     * If the ticket does not exist, this should throw a TicketNotFound.
     *
     * @param getAllTicketsRequest request object containing the project ID
     * @return getAllTicketsResult result object containing the ticketModel list of API defined {@link TicketModel}s
     */
    public GetAllTicketsResult handleRequest(final GetAllTicketsRequest getAllTicketsRequest) {
        log.info("Received GetPlaylistSongsRequest {}", getAllTicketsRequest);
        ProjectModelConverter projectModelConverter = new ProjectModelConverter();

        List<Ticket> tickets = ticketDao.getAllTicketsForProjectId(getAllTicketsRequest.getProjectId());
        List<TicketModel> ticketModels = projectModelConverter.toTicketModelList(tickets);

        return GetAllTicketsResult.builder()
            .withTicketList(ticketModels)
            .build();
    }

}
