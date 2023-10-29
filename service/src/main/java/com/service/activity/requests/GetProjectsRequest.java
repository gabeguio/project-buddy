package com.service.activity.requests;

public class GetProjectsRequest {


    private GetProjectsRequest() {}


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public GetProjectsRequest build() {
            return new GetProjectsRequest();
        }
    }
}
