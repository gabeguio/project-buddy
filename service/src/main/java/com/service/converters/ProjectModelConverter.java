package com.service.converters;

import java.util.ArrayList;
import java.util.List;

import com.service.dynamodb.models.Project;
import com.service.dynamodb.models.Ticket;
import com.service.models.ProjectModel;
import com.service.models.TicketModel;

public class ProjectModelConverter{
    /**
     * Converts between Data and API models.
     */
        /**
         * Converts a provided {@link Project} into a {@link ProjectModel} representation.
         *
         * @param project the project to convert
         * @return the converted project
         */
        public ProjectModel toProjectModel(Project project) {

            return ProjectModel.builder()
                    .withProjectId(project.getProjectId())
                    .withOwner(project.getOwner())
                    .withDateCreated(project.getDateCreated())
                    .withDateLastUpdated(project.getDateLastUpdated())
                    .withDateDue(project.getDateDue())
                    .withTitle(project.getTitle())
                    .withDescription(project.getDescription())
                    .withTotalCompletedTasks(project.getTotalCompletedTasks())
                    .withTotalTasks(project.getTotalTasks())
                    .withTopMembersByTasksCompleted(project.getTopMemberByTasksCompleted())
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

    public List<TicketModel> toTicketModelList(List<Ticket> tickets) {
        List<TicketModel> ticketModels = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketModels.add(toTicketModel(ticket));
        }

        return ticketModels;
    }

    public List<ProjectModel> toProjectModelList(List<Project> projects) {
        List<ProjectModel> projectModels = new ArrayList<>();

        for (Project project : projects) {
            projectModels.add(toProjectModel(project));
        }

        return projectModels;
    }


    }


