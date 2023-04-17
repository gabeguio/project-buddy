package com.nashss.se.musicplaylistservice.activity.requests;

import com.amazonaws.internal.config.Builder;
import com.amazonaws.services.dynamodbv2.model.Delete;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeleteTicketRequest.class)
public class DeleteTicketRequest {
    private final String projectId;
    private  final String ticketId;

    private DeleteTicketRequest(String projectId, String ticketId){
            this.projectId = projectId;
            this.ticketId = ticketId;

    }

    public String getProjectId() {
        return projectId;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString(){
        return "DeleteTicketRequest{" + "id='" + ticketId + '\'' +
                ", projectId='" + projectId + '\'' + '}';

    }

    public static Builder builder(){
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String projectId;
        private String ticketId;

        public Builder withProjectId(String projectId){
            this.projectId = projectId;
            return this;
        }

        public Builder withTicketId(String ticketId){
            this.ticketId = ticketId;
            return this;
        }

        public DeleteTicketRequest build(){
            return new DeleteTicketRequest(projectId, ticketId);
        }
    }
}
