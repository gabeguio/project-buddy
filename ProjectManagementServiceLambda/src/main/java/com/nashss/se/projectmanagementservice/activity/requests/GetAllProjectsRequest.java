package com.nashss.se.projectmanagementservice.activity.requests;

public class GetAllProjectsRequest {


    private GetAllProjectsRequest() {}


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public GetAllProjectsRequest build() {
            return new GetAllProjectsRequest();
        }
    }
}
