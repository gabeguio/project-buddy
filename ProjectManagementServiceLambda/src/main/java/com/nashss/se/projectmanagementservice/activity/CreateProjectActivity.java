package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.CreateProjectRequest;
import com.nashss.se.projectmanagementservice.activity.results.CreateProjectResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import com.nashss.se.projectmanagementservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.projectmanagementservice.models.ProjectModel;
import com.nashss.se.projectmanagementservice.utils.ProjectManagementServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * Implementation of the CreateProjectActivity for CreateProject API.
 * <p>
 * This API allows the customer to create a new playlist with no songs.
 */
public class CreateProjectActivity {
    private final Logger log = LogManager.getLogger();
    private final ProjectDao projectDao;

    /**
     * Instantiates a new CreateProjectActivity object.
     *
     * @param projectDao ProjectDao to access the projects table.
     */
    @Inject
    public CreateProjectActivity( ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    /**
     * This method handles the incoming request by persisting a new project
     * with the provided project ID from the request.
     * <p>
     * It then returns the newly created project
     * <p>
     * If the provided project ID has invalid characters, throws an
     * InvalidAttributeValueException
     *
     * @param createProjectRequest    request object containing the projectId associated with it
     * @return createProjectResult result object containing the API defined {@link ProjectModel}
     */
    public CreateProjectResult handleRequest(final CreateProjectRequest createProjectRequest) {
        log.info("Received CreateProjectRequest {}", createProjectRequest);

        if (!ProjectManagementServiceUtils.isValidString(createProjectRequest.getTitle())) {
            throw new InvalidAttributeValueException("Project Title [" + createProjectRequest.getDescription() +
                    "] contains illegal characters");
        }

        Project newProject = new Project();
        newProject.setTitle(createProjectRequest.getTitle());
        newProject.setProjectId(ProjectManagementServiceUtils.generateProjectId(createProjectRequest.getTitle()));
        newProject.setDescription(createProjectRequest.getDescription());
        newProject.setStatus(createProjectRequest.getStatus());

        projectDao.saveProject(newProject);

        ProjectModel projectModel = new ProjectModelConverter().toProjectModel(newProject);
        return CreateProjectResult.builder()
                .withProject(projectModel)
                .build();
    }
}
