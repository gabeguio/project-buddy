package com.nashss.se.musicplaylistservice.activity.requests;

import com.amazonaws.internal.config.Builder;
import com.amazonaws.services.dynamodbv2.model.Delete;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeleteTicketRequest.class)
public class DeleteTicketRequest {
    private final String projectId;
    private  final String ticketId;
    private final String title;
    private final String description;
    private final String status;

    private DeleteTicketRequest(String projectId, String ticketId, String title, String description, String status){
            this.projectId = projectId;
            this.ticketId = ticketId;
            this.title = title;
            this.description = description;
            this.status = status;

    }

    public String getProjectId() {
        return projectId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
    @Override
    public String toString(){
        return "DeleteTicketRequest{" + "id='" + ticketId + '\'' +
                ", projectId='" + projectId + '\'' + ", title=" + title + '}';

    }

    public static Builder builder(){
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String projectId;
        private String ticketId;
        private String title;
        private String description;
        private String status;


        public Builder withProjectId(String projectId){
            this.projectId = projectId;
            return this;
        }

        public Builder withTicketId(String ticketId){
            this.ticketId = ticketId;
            return this;
        }

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withStatus(String status){
            this.status = status;
            return this;
        }

        public DeleteTicketRequest build(){
            return new DeleteTicketRequest(projectId, ticketId, title, description,status);
        }
    }
}
