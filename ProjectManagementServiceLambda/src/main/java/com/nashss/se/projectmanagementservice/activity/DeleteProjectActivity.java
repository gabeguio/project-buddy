package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.DeleteProjectRequest;
import com.nashss.se.projectmanagementservice.activity.results.DeleteProjectResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import com.nashss.se.projectmanagementservice.models.ProjectModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteProjectActivity {

    private final Logger log = LogManager.getLogger();
    private final ProjectDao projectDao;

    @Inject
    public DeleteProjectActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public DeleteProjectResult handleRequest(final DeleteProjectRequest deleteProjectRequest){
        log.info("Received request to delete project with id {}", deleteProjectRequest);
        Project project = new Project();
        project.setProjectId(deleteProjectRequest.getProjectId());
        project.setDescription(deleteProjectRequest.getDescription());
        project.setTitle(deleteProjectRequest.getTitle());
        project.setStatus(deleteProjectRequest.getStatus());

        projectDao.deleteProject(project);
        ProjectModel projectModel = new ProjectModelConverter().toProjectModel(project);

        return DeleteProjectResult.builder().withProject(projectModel).build();
    }
}
