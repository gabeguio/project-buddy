package com.service.activity;

import com.service.activity.requests.GetProjectRequest;
import com.service.activity.results.GetProjectResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import com.service.models.ProjectModel;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Implementation of the GetProjectActivity for the TicketManagementService's GetProject API.
 * This API allows a user to get a previously saved project by its projectID.
 */
public class GetProjectActivity {

    private final Logger log = LogManager.getLogger();

    private final ProjectDao projectDao;

    /**
     * Instantiating a new GetProjectActivity object.
     * @param projectDao ProjectDao to access the project table.
     */
    @Inject
    public GetProjectActivity(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    /**
     * This method handles the incoming request by retrieving the project from the database.
     * It then returns the project.
     * If the project does not exist, this should throw a ProjectNotFoundException.
     *
     * @param getProjectRequest request an object containing the project ID.
     * @return getProjectResult result object containing the API defined {@link ProjectModel}.
     */

    public GetProjectResult handleRequest(final GetProjectRequest getProjectRequest){
        log.info("Received GetProjectRequest {}", getProjectRequest);
        String requestedId = getProjectRequest.getProjectId();
        Project project = projectDao.getProject(requestedId);
        ProjectModel projectModel = new ProjectModelConverter().toProjectModel(project);

        return GetProjectResult.builder().withProject(projectModel).build();
    }
}
