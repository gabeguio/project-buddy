package com.service.activity;

import com.service.activity.requests.UpdateProjectStatusRequest;
import com.service.activity.results.UpdateProjectStatusResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;

import com.service.metrics.MetricsPublisher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class UpdateProjectStatusActivity {

    private final Logger log = LogManager.getLogger();

    private final ProjectDao projectDao;
    private final MetricsPublisher metricsPublisher;


    @Inject
    public UpdateProjectStatusActivity(ProjectDao projectDao, MetricsPublisher metricsPublisher) {
        this.projectDao = projectDao;
        this.metricsPublisher = metricsPublisher;
    }

    public UpdateProjectStatusResult handleRequest(final UpdateProjectStatusRequest updateProjectStatusRequest){
        log.info("Received UpdateProjectStatusRequest{}", updateProjectStatusRequest);

        Project project = projectDao.getProject(updateProjectStatusRequest.getProjectId());

//        project.setStatus(updateProjectStatusRequest.getStatus());
        project = projectDao.saveProject(project);
        return UpdateProjectStatusResult.builder()
                .withProject(new ProjectModelConverter()
                        .toProjectModel(project))
                .build();
    }
}
