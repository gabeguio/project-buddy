package com.nashss.se.projectmanagementservice.models;

import java.util.Objects;

public class ProjectModel {

    private final String projectId;
    private final String title;
    private final String description;
    private final String status;

    private ProjectModel(String projectId, String title, String description, String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getStatus() {
        return status;
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
        private String status;

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

        public Builder withStatus(String projectStatus) {
            this.status = projectStatus;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(projectId, title, description, status);

        }


    }
}
