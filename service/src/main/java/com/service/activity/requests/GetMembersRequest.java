package com.service.activity.requests;

public class GetMembersRequest {
    private final String projectId;

    private GetMembersRequest(String projectId) {this.projectId = projectId; }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "GetMembersRequest{" +
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

        public GetMembersRequest build() {
            return new GetMembersRequest(projectId);
        }
    }
}