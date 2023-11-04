package com.service.models;

import java.util.Objects;

public class MemberModel {

    private final String projectId;
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String role;
    private final String company;
    private final String email;

    public MemberModel(String projectId, String userId, String firstName, String lastName, String role, String company, String email) {

        this.projectId = projectId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.company = company;
        this.email = email;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
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
        return Objects.equals(projectId, that.projectId) && Objects.equals(userId, that.userId) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, role);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder(); }

    public static class Builder {
        private String projectId;
        private String userId;
        private String firstName;
        private String lastName;
        private String role;
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

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
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
            return new MemberModel(projectId, userId, firstName, lastName, role, company, email);

        }
    }
}
