package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.ProjectModel;

public class UpdateProjectDetailsResult {

    private final ProjectModel project;

    public UpdateProjectDetailsResult(ProjectModel project) {
        this.project = project;
    }

    public ProjectModel getProject(){
        return project;
    }

    @Override
    public String toString() {
        return "UpdateProjectDetailsResult{" +
                "project=" + project +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private ProjectModel project;

        public Builder withProject(ProjectModel project) {
            this.project = project;
            return this;
        }

        public UpdateProjectDetailsResult build() {
            return new UpdateProjectDetailsResult(project);
        }
    }
}
