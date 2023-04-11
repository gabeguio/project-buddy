package com.nashss.se.musicplaylistservice.models;

import java.util.Objects;

import com.nashss.se.musicplaylistservice.ProjectStatus.ProjectStatus;

public class ProjectModel {

    private String projectId;
    private String title;
    private String description;
    private ProjectStatus status;

    private ProjectModel(String projectId, String title, String description, ProjectStatus status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectModel that = (ProjectModel) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(title, that.title) &&
            Objects.equals(description, that.description) && status == that.status;
    }

    @Override
    public int hashCode() {return Objects.hash(projectId, title, description, status);}

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder(); }

    public static class Builder {
        private String projectId;
        private String title;
        private String description;
        private ProjectStatus status;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withStatus(ProjectStatus projectStatus) {
            this.status = projectStatus;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(projectId, title, description, status);

        }


    }
}
