package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateProjectStatusResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;

import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;
import com.nashss.se.musicplaylistservice.metrics.MetricsConstants;

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

        project.setStatus(updateProjectStatusRequest.getStatus());
        project = projectDao.saveProject(project);
        return UpdateProjectStatusResult.builder()
                .withProject(new ProjectModelConverter()
                        .toProjectModel(project))
                .build();
    }
}
