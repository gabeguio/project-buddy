package com.service.models;

import java.util.List;
import java.util.Objects;

import static com.service.utils.CollectionUtils.copyToList;

public class MemberModel {

    private final String projectId;
    private final String userId;
    private final String memberId;
    private final String dateJoined;
    private final String role;
    private final List<String> currentTasks;
    private final List<String> tasksCompleted;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String email;

    public MemberModel(String projectId, String userId, String memberId, String dateJoined, String role, List<String> currentTasks, List<String> tasksCompleted, String firstName, String lastName, String company, String email) {
        this.projectId = projectId;
        this.userId = userId;
        this.memberId = memberId;
        this.dateJoined = dateJoined;
        this.role = role;
        this.currentTasks = currentTasks;
        this.tasksCompleted = tasksCompleted;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getRole() {
        return role;
    }

    public List<String> getCurrentTasks() {
        return currentTasks;
    }

    public List<String> getTasksCompleted() {
        return tasksCompleted;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberModel that = (MemberModel) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(userId, that.userId) && Objects.equals(memberId, that.memberId) && Objects.equals(dateJoined, that.dateJoined) && Objects.equals(role, that.role) && Objects.equals(currentTasks, that.currentTasks) && Objects.equals(tasksCompleted, that.tasksCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, memberId, dateJoined, role, currentTasks, tasksCompleted);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder(); }

    public static class Builder {
        private String projectId;
        private String userId;
        private String memberId;
        private String dateJoined;
        private String role;
        private List<String> currentTasks;
        private List<String> tasksCompleted;
        private String firstName;
        private String lastName;
        private String company;
        private String email;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withDateJoined(String dateJoined) {
            this.dateJoined = dateJoined;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public Builder withCurrentTasks(List<String> currentTasks) {
            this.currentTasks = copyToList(currentTasks);
            return this;
        }

        public Builder withTasksCompleted(List<String> tasksCompleted) {
            this.tasksCompleted = copyToList(tasksCompleted);
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public MemberModel build() {
            return new MemberModel(projectId, userId, memberId, dateJoined, role, currentTasks, tasksCompleted, firstName, lastName, company, email);

        }
    }
}
