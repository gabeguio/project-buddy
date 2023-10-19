package com.service.models;

import java.util.Objects;

public class TicketModel {
    private final String projectId;
    private final String ticketId;
    private final String title;
    private final String description;
    private final String status;

    public TicketModel(String projectId, String ticketId, String title, String description, String status) {
        this.projectId = projectId;
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTicketId() {
        return ticketId;
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
        TicketModel that = (TicketModel) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(ticketId, that.ticketId) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, ticketId, title, description, status);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String projectId;
        private String ticketId;
        private String title;
        private String description;
        private String status;

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withTicketId(String ticketId) {
            this.ticketId = ticketId;
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

        public TicketModel build() {
            return new TicketModel(projectId, ticketId, title, description, status);
        }
    }
}