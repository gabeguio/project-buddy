package com.service.test.helper;

import java.util.List;

import com.service.dynamodb.models.Project;
import com.service.models.ProjectModel;


public class ProjectTestHelper {

    public static Project generateProject() {
        Project project = new Project();
        project.setProjectId("projectId");
        project.setTitle("title");
        project.setDescription("description");
        project.setStatus("status");
        return project;
    }

    public static boolean AssertProjectModelEquals(List<Project> projectList, List<ProjectModel> projectModels) {
        for (int i = 0; i < projectModels.size(); i ++) {
            if (!projectList.get(i).getProjectId().equals(projectModels.get(i).getProjectId())) {
                return false;
            }
            if (!projectList.get(i).getTitle().equals(projectModels.get(i).getTitle())) {
                return false;
            }
            if (!projectList.get(i).getDescription().equals(projectModels.get(i).getDescription())) {
                return false;
            }
            if (!projectList.get(i).getStatus().equals(projectModels.get(i).getStatus())) {
                return false;
            }
        }

        return true;
    }
}
