package com.nashss.se.projectmanagementservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateTicketStatusRequest.Builder.class)
public class UpdateTicketStatusRequest {

    private final String status;
    private final String projectId;
    private final String ticketId;

    private UpdateTicketStatusRequest(String projectId, String ticketId, String status){
        this.status = status;
        this.projectId = projectId;
        this.ticketId = ticketId;
    }

    public String getStatus(){
        return status;
    }

    public String getProjectId(){
        return projectId;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "UpdateTicketStatusRequest{" +
                "status='" + status + '\'' +
                ", projectId='" + projectId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String status;
        private String projectId;

        private String ticketId;

        public Builder withStatus(String status){
            this.status = status;
            return this;
        }

        public Builder withProjectId(String projectId){
            this.projectId = projectId;
            return this;
        }

        public Builder withTicketId(String ticketId){
            this.ticketId = ticketId;
            return this;
        }

        public UpdateTicketStatusRequest build(){
            return new UpdateTicketStatusRequest(projectId, ticketId, status);
        }
    }
}
