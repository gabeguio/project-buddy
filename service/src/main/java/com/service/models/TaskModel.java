package com.service.models;

import java.util.Objects;

public class TaskModel {
    private final String projectId;
    private final String taskId;
    private final String memberId;
    private final String owner;
    private final String dateCreated;
    private final String dateLastUpdated;
    private final String dateDue;
    private final String title;
    private final String description;
    private final String status;

    public TaskModel(String projectId, String taskId, String memberId, String owner, String dateCreated, String dateLastUpdated, String dateDue, String title, String description, String status) {
        this.projectId = projectId;
        this.taskId = taskId;
        this.memberId = memberId;
        this.owner = owner;
        this.dateCreated = dateCreated;
        this.dateLastUpdated = dateLastUpdated;
        this.dateDue = dateDue;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getMemberId() {
        return memberId;
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

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(projectId, taskModel.projectId) && Objects.equals(taskId, taskModel.taskId) && Objects.equals(memberId, taskModel.memberId) && Objects.equals(owner, taskModel.owner) && Objects.equals(dateCreated, taskModel.dateCreated) && Objects.equals(dateLastUpdated, taskModel.dateLastUpdated) && Objects.equals(dateDue, taskModel.dateDue) && Objects.equals(title, taskModel.title) && Objects.equals(description, taskModel.description) && Objects.equals(status, taskModel.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, taskId, memberId, owner, dateCreated, dateLastUpdated, dateDue, title, description, status);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String projectId;
        private String taskId;
        private String memberId;
        private String owner;
        private String dateCreated;
        private String dateLastUpdated;
        private String dateDue;
        private String title;
        private String description;
        private String status;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
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

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public TaskModel build() {
            return new TaskModel(projectId, taskId, memberId, owner, dateCreated, dateLastUpdated, dateDue, title, description, status);
        }
    }

}
