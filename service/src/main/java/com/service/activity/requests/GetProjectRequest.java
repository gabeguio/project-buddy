package com.service.activity.requests;

public class GetProjectRequest {

    private final String id;

    private GetProjectRequest(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString(){
        return "GetProjectRequest{" + "id=" + id + '\'' + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String id;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public GetProjectRequest build(){
            return new GetProjectRequest(id);
        }
    }
}
