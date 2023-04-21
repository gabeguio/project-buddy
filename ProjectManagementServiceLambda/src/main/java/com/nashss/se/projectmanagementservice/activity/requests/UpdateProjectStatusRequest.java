package com.nashss.se.projectmanagementservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateProjectStatusRequest.Builder.class)
public class UpdateProjectStatusRequest {

    private final String status;
    private final String projectId;

    private UpdateProjectStatusRequest(String projectId, String status){
        this.status = status;
        this.projectId = projectId;
    }

    public String getStatus(){
        return status;
    }

    public String getProjectId(){
        return projectId;
    }

    @Override
    public String toString(){
    return "UpdateProjectStatusRequest{" + "projectId='" + projectId + '\'' + ", status='" + status + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String status;
        private String projectId;

        public Builder withStatus(String status){
            this.status = status;
            return this;
        }

        public Builder withProjectId(String projectId){
            this.projectId = projectId;
            return this;
        }

        public UpdateProjectStatusRequest build(){
            return new UpdateProjectStatusRequest(projectId, status);
        }
    }
}
