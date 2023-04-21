package com.nashss.se.projectmanagementservice.activity.results;

import com.nashss.se.projectmanagementservice.models.ProjectModel;

public class UpdateProjectStatusResult {

    private final ProjectModel project;

    private UpdateProjectStatusResult(ProjectModel project){
        this.project = project;
    }

    public ProjectModel getProject(){
        return project;
    }

    @Override
    public String toString(){
        return "UpdateProjectStatus{" + "project=" +
                project + '}';
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

        public UpdateProjectStatusResult build(){
            return new UpdateProjectStatusResult(project);
        }
    }
}
