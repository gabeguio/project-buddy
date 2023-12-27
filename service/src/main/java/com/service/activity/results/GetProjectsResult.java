package com.service.activity.results;

import java.util.ArrayList;
import java.util.List;
import com.service.models.ProjectModel;

public class GetProjectsResult {
    private final List<ProjectModel> projectModelList;

    private GetProjectsResult(List<ProjectModel> projectModelList) {
        this.projectModelList = projectModelList;
    }

    public List<ProjectModel> getProjectModelList() {
        return new ArrayList<>(projectModelList);
    }

    @Override
    public String toString() {
        return "GetProjectsResult{" +
            "projectModelList=" + projectModelList +
            '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ProjectModel> projectList;

        public Builder withProjectModelList(List<ProjectModel> projectList) {
            this.projectList = projectList;
            return this;
        }

        public GetProjectsResult build() {
            return new GetProjectsResult(projectList);
        }
    }


}
