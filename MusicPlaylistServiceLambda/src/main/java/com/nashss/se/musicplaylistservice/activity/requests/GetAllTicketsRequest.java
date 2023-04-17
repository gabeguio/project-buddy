package com.nashss.se.musicplaylistservice.activity.requests;

public class GetAllTicketsRequest {
    private final String projectId;

    private GetAllTicketsRequest(String projectId) {this.projectId = projectId; }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "GetAllTicketsRequest{" +
            "projectId='" + projectId + '\'' +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String projectId;

        public Builder withId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public GetAllTicketsRequest build() {
            return new GetAllTicketsRequest(projectId);
        }
    }
}
