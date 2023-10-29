package com.service.models;

import java.util.Objects;

public class ProjectModel {

    private final String projectId;
    private final String owner;
    private final String dateCreated;
    private final String title;
    private final String description;
    private final String dueDate;
    private final Integer tasksCompleted;
    private final Integer totalTasks;
    private final String topContributor;

    public ProjectModel(String projectId, String owner, String dateCreated, String title, String description, String dueDate, Integer tasksCompleted, Integer totalTasks, String topContributor) {
        this.projectId = projectId;
        this.owner = owner;
        this.dateCreated = dateCreated;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.tasksCompleted = tasksCompleted;
        this.totalTasks = totalTasks;
        this.topContributor = topContributor;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Integer getTasksCompleted() {
        return tasksCompleted;
    }

    public Integer getTotalTasks() {
        return totalTasks;
    }

    public String getTopContributor() {
        return topContributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectModel that = (ProjectModel) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(owner, that.owner) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(dueDate, that.dueDate) && Objects.equals(tasksCompleted, that.tasksCompleted) && Objects.equals(totalTasks, that.totalTasks) && Objects.equals(topContributor, that.topContributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, owner, dateCreated, title, description, dueDate, tasksCompleted, totalTasks, topContributor);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder(); }

    public static class Builder {
        private String projectId;
        private String owner;
        private String dateCreated;
        private String title;
        private String description;
        private String dueDate;
        private Integer tasksCompleted;
        private Integer totalTasks;
        private String topContributor;

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

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder withTasksCompleted(Integer tasksCompleted) {
            this.tasksCompleted = tasksCompleted;
            return this;
        }

        public Builder withTotalTasks(Integer totalTasks) {
            this.totalTasks = totalTasks;
            return this;
        }

        public Builder withTopContributor(String topContributor) {
            this.topContributor = topContributor;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(projectId, owner, dateCreated, title, description, dueDate, tasksCompleted, totalTasks, topContributor);

        }


    }
}
