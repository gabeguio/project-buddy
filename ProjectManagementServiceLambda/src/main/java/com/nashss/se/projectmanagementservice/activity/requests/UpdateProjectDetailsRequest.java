package com.nashss.se.projectmanagementservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateProjectDetailsRequest.Builder.class)
public class UpdateProjectDetailsRequest {

    private final String projectId;
    private final String title;
    private final String description;
    private final String status;

    public UpdateProjectDetailsRequest(String projectId, String title, String description, String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
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
    public String toString() {
        return "UpdateProjectDetailsRequest{" +
                "projectId='" + projectId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private String projectId;
        private String title;
        private String description;
        private String status;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public UpdateProjectDetailsRequest build() {
            return new UpdateProjectDetailsRequest(projectId, title, description, status);
        }
    }
}

