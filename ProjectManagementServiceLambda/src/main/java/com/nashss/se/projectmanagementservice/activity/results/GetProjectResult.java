package com.nashss.se.projectmanagementservice.activity.results;

import com.nashss.se.projectmanagementservice.models.ProjectModel;

public class GetProjectResult {

    private final ProjectModel project;


    private GetProjectResult(ProjectModel project){
        this.project = project;
    }

    public ProjectModel getProject(){
        return project;
    }

    @Override
    public String toString() {
        return "GetProjectResult{" + "playlist=" + project + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private ProjectModel project;

        public Builder withProject(ProjectModel project){
            this.project = project;
            return this;
        }

        public GetProjectResult build(){
            return new GetProjectResult(project);
        }
    }
}
