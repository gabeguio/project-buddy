package com.nashss.se.musicplaylistservice.activity.requests;

import java.util.List;

import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;

public class GetPlaylistRequest {
    private final String id;

    private GetPlaylistRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GetPlaylistRequest{" + "id='" + id + '\'' + '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String projectId;
        private List<Ticket> tickets;

        public Builder withId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public GetPlaylistRequest build() {
            return new GetPlaylistRequest(projectId);
        }
    }
}
