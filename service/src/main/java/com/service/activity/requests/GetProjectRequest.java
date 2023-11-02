package com.service.activity.requests;

public class GetProjectRequest {

    private final String projectId;

    private GetProjectRequest(String projectId){
        this.projectId = projectId;
    }

    public String getProjectId(){
        return projectId;
    }

    @Override
    public String toString(){
        return "GetProjectRequest{" + "projectId=" + projectId + '\'' + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String projectId;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public GetProjectRequest build(){
            return new GetProjectRequest(projectId);
        }
    }
}
