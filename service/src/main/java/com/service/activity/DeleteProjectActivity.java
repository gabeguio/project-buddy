package com.service.activity;

import com.service.activity.requests.DeleteProjectRequest;
import com.service.activity.results.DeleteProjectResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import com.service.models.ProjectModel;
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
