package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.musicplaylistservice.models.ProjectModel;
import org.apache.commons.lang3.builder.Builder;

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
