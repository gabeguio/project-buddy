package com.service.models;

import java.util.Objects;

public class ProjectModel {

    private final String projectId;
    private final String owner;
    private final String dateCreated;
    private final String dateLastUpdated;
    private final String dateDue;
    private final String title;
    private final String description;
    private final Integer totalCompletedTasks;
    private final Integer totalTasks;
    private final String topMemberByTasksCompleted;

    public ProjectModel(String projectId, String owner, String dateCreated, String dateLastUpdated, String dateDue, String title, String description, Integer totalCompletedTasks, Integer totalTasks, String topMemberByTasksCompleted) {
        this.projectId = projectId;
        this.owner = owner;
        this.dateCreated = dateCreated;
        this.dateLastUpdated = dateLastUpdated;
        this.dateDue = dateDue;
        this.title = title;
        this.description = description;
        this.totalCompletedTasks = totalCompletedTasks;
        this.totalTasks = totalTasks;
        this.topMemberByTasksCompleted = topMemberByTasksCompleted;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getOwner() {
        return owner;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public String getDateDue() {
        return dateDue;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTotalCompletedTasks() {
        return totalCompletedTasks;
    }

    public Integer getTotalTasks() {
        return totalTasks;
    }

    public String getTopMemberByTasksCompleted() {
        return topMemberByTasksCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectModel that = (ProjectModel) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(owner, that.owner) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateLastUpdated, that.dateLastUpdated) && Objects.equals(dateDue, that.dateDue) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(totalCompletedTasks, that.totalCompletedTasks) && Objects.equals(totalTasks, that.totalTasks) && Objects.equals(topMemberByTasksCompleted, that.topMemberByTasksCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, owner, dateCreated, dateLastUpdated, dateDue, title, description, totalCompletedTasks, totalTasks, topMemberByTasksCompleted);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder(); }

    public static class Builder {
        private String projectId;
        private String owner;
        private String dateCreated;
        private String dateLastUpdated;
        private String dateDue;
        private String title;
        private String description;
        private Integer totalCompletedTasks;
        private Integer totalTasks;
        private String topMemberByTasksCompleted;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder withDateLastUpdated(String dateLastUpdated) {
            this.dateLastUpdated = dateLastUpdated;
            return this;
        }

        public Builder withDateDue(String dateDue) {
            this.dateDue = dateDue;
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

        public Builder withTotalCompletedTasks(Integer totalCompletedTasks) {
            this.totalCompletedTasks = totalCompletedTasks;
            return this;
        }

        public Builder withTotalTasks(Integer totalTasks) {
            this.totalTasks = totalTasks;
            return this;
        }

        public Builder withTopMembersByTasksCompleted(String topMemberByTasksCompleted) {
            this.topMemberByTasksCompleted = topMemberByTasksCompleted;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(projectId, owner, dateCreated, dateLastUpdated, dateDue, title, description, totalCompletedTasks, totalTasks, topMemberByTasksCompleted);

        }


    }
}
