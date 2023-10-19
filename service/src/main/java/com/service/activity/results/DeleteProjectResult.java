package com.service.activity.results;

import com.service.models.ProjectModel;

public class DeleteProjectResult {
    private final ProjectModel project;

    private DeleteProjectResult(ProjectModel project){
        this.project = project;
    }

    public ProjectModel getProject(){
        return project;
    }

    @Override
    public String toString(){
        return "DeleteProjectResult{" + "project=" + project + '}';
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

        public DeleteProjectResult build(){
            return new DeleteProjectResult(project);
        }
    }
}
