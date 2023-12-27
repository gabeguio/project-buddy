package com.service.activity.requests;

public class GetTasksRequest {
    private final String projectId;

    private GetTasksRequest(String projectId) {this.projectId = projectId; }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "GetTasksRequest{" +
            "projectId='" + projectId + '\'' +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String projectId;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public GetTasksRequest build() {
            return new GetTasksRequest(projectId);
        }
    }
}
