package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateProjectStatusResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeException;
import com.nashss.se.musicplaylistservice.exceptions.ProjectNotFoundException;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;
import com.nashss.se.musicplaylistservice.metrics.MetricsConstants;
import com.nashss.se.musicplaylistservice.utils.TicketManagementServiceUtils;
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
//        if(!TicketManagementServiceUtils.isValidString(updateProjectStatusRequest.getProjectId())){
//            publishExceptionMetrics(true, false);
//            throw new InvalidAttributeException("Project ID [" + updateProjectStatusRequest.getProjectId() + "] contains illegal characters")
//        }
        project.setStatus(updateProjectStatusRequest.getStatus());
        project = projectDao.saveProject(project);
        return UpdateProjectStatusResult.builder()
                .withProject(new ProjectModelConverter()
                        .toProjectModel(project))
                .build();
    }
    private void publishExceptionMetrics(final boolean isInvalidAttributeValue,
                                         final boolean isInvalidAttributeChange) {
        metricsPublisher.addCount(MetricsConstants.UPDATEPLAYLIST_INVALIDATTRIBUTEVALUE_COUNT,
                isInvalidAttributeValue ? 1 : 0);
        metricsPublisher.addCount(MetricsConstants.UPDATEPLAYLIST_INVALIDATTRIBUTECHANGE_COUNT,
                isInvalidAttributeChange ? 1 : 0);
    }
}
