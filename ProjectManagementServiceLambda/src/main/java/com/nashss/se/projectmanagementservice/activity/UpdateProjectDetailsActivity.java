package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.UpdateProjectDetailsRequest;
import com.nashss.se.projectmanagementservice.activity.results.UpdateProjectDetailsResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateProjectDetailsActivity {

    private final Logger log = LogManager.getLogger();

    private final ProjectDao projectDao;
    @Inject
    public UpdateProjectDetailsActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public UpdateProjectDetailsResult handleRequest(final UpdateProjectDetailsRequest updateProjectDetailsRequest) {
        log.info("Received UpdateProjectDetailsRequest {}", updateProjectDetailsRequest);

        Project project = projectDao.getProject(updateProjectDetailsRequest.getProjectId());

        project.setStatus(updateProjectDetailsRequest.getStatus());
        project.setDescription(updateProjectDetailsRequest.getDescription());
        project.setTitle(updateProjectDetailsRequest.getTitle());

        project = projectDao.saveProject(project);

        return UpdateProjectDetailsResult.builder().withProject(new ProjectModelConverter()
                        .toProjectModel(project))
                .build();

    }


}
