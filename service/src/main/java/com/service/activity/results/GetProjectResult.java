package com.service.activity.results;

import com.service.models.ProjectModel;

public class GetProjectResult {

    private final ProjectModel projectModel;


    private GetProjectResult(ProjectModel projectModel){
        this.projectModel = projectModel;
    }

    public ProjectModel getProjectModel(){
        return projectModel;
    }

    @Override
    public String toString() {
        return "GetProjectResult{" + "projectModel=" + projectModel + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private ProjectModel projectModel;

        public Builder withProject(ProjectModel projectModel){
            this.projectModel = projectModel;
            return this;
        }

        public GetProjectResult build(){
            return new GetProjectResult(projectModel);
        }
    }
}
