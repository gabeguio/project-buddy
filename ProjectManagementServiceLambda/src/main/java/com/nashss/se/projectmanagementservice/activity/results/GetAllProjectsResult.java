package com.nashss.se.projectmanagementservice.activity.results;

import java.util.ArrayList;
import java.util.List;

import com.nashss.se.projectmanagementservice.models.ProjectModel;

public class GetAllProjectsResult {
    private final List<ProjectModel> projectModels;

    private GetAllProjectsResult(List<ProjectModel> projectModels) {
        this.projectModels = projectModels;
    }

    public List<ProjectModel> getProjectList() {
        return new ArrayList<>(projectModels);
    }

    @Override
    public String toString() {
        return "GetAllProjectsResult{" +
            "projectModels=" + projectModels +
            '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ProjectModel> projectList;

        public Builder withProjectList(List<ProjectModel> projectList) {
            this.projectList = projectList;
            return this;
        }

        public GetAllProjectsResult build() {
            return new GetAllProjectsResult(projectList);
        }
    }


}
