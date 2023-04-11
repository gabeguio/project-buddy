package com.nashss.se.musicplaylistservice.converters;

import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.models.ProjectModel;
import com.nashss.se.musicplaylistservice.models.TicketModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts between Data and API models.
 */
public class ModelConverter {
    /**
     * Converts a provided {@link Project} into a {@link ProjectModel} representation.
     *
     * @param project the project to convert
     * @return the converted project
     */
    public ProjectModel toProjectModel(Project project) {

        return ProjectModel.builder()
                .withProjectId(project.getProjectId())
                .withTitle(project.getTitle())
                .withDescription(project.getDescription())
                .withStatus(project.getStatus())
                .build();
    }

    /**
     * Converts a provided Ticket into a TicketModel representation.
     *
     * @param ticket the ticket to convert to TicketModel
     * @return the converted SongModel with fields mapped from albumTrack
     */
    public TicketModel toTicketModel(Ticket ticket) {
        return TicketModel.builder()
             .withProjectId(ticket.getProjectId())
             .withTicketId(ticket.getTicketId())
             .withTitle(ticket.getTitle())
             .withDescription(ticket.getDescription())
             .withStatus(ticket.getStatus())
             .build();
    }


}
