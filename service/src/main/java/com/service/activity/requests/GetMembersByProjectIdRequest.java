package com.service.activity.requests;

public class GetMembersByProjectIdRequest {
    private final String projectId;

    private GetMembersByProjectIdRequest(String projectId) {this.projectId = projectId; }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "GetMembersByProjectIdRequest{" +
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

        public GetMembersByProjectIdRequest build() {
            return new GetMembersByProjectIdRequest(projectId);
        }
    }
}