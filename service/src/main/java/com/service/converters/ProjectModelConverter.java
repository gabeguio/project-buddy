package com.service.converters;

import java.util.ArrayList;
import java.util.List;

import com.service.dynamodb.models.Project;

import com.service.dynamodb.models.User;
import com.service.models.ProjectModel;

public class ProjectModelConverter{
    /**
     * Converts between Data and API models.
     */
        /**
         * Converts a provided {@link Project} into a {@link ProjectModel} representation.
         *
         * @param project the project to convert
         * @return the converted project
         */
        public ProjectModel toProjectModel(Project project, User user) {

            return ProjectModel.builder()
                    .withProjectId(project.getProjectId())
                    .withOwner(user.getFirstName() + " " + user.getLastName())
                    .withDateCreated(project.getDateCreated())
                    .withDateLastUpdated(project.getDateLastUpdated())
                    .withDateDue(project.getDateDue())
                    .withTitle(project.getTitle())
                    .withDescription(project.getDescription())
                    .withTotalCompletedTasks(project.getTotalCompletedTasks())
                    .withTotalTasks(project.getTotalTasks())
                    .withTopMembersByTasksCompleted(project.getTopMemberByTasksCompleted())
                    .build();
        }


    public List<ProjectModel> toProjectModelList(List<Project> projects, List<User> users) {
        List<ProjectModel> projectModels = new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {
            projectModels.add(toProjectModel(projects.get(i), users.get(i)));
        }

        return projectModels;
    }


    }


