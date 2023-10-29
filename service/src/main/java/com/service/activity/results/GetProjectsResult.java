package com.service.activity.results;

import java.util.ArrayList;
import java.util.List;

import com.service.models.ProjectModel;

public class GetProjectsResult {
    private final List<ProjectModel> projectModels;

    private GetProjectsResult(List<ProjectModel> projectModels) {
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

        public GetProjectsResult build() {
            return new GetProjectsResult(projectList);
        }
    }


}
