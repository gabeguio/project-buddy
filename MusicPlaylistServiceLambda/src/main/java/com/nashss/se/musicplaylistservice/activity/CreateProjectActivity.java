package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreatePlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.CreateProjectRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreatePlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.CreateProjectResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.PlaylistDao;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.models.PlaylistModel;
import com.nashss.se.musicplaylistservice.models.ProjectModel;
import com.nashss.se.musicplaylistservice.utils.TicketManagementServiceUtils;
import com.nashss.se.projectresources.music.playlist.servic.util.MusicPlaylistServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

        if (!TicketManagementServiceUtils.isValidString(createProjectRequest.getProjectId())) {
            throw new InvalidAttributeValueException("Project ID [" + createProjectRequest.getProjectId() +
                    "] contains illegal characters");
        }

        if (!TicketManagementServiceUtils.isValidString(createProjectRequest.getTitle())) {
            throw new InvalidAttributeValueException("Project Title [" + createProjectRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!TicketManagementServiceUtils.isValidString(createProjectRequest.getDescription())) {
            throw new InvalidAttributeValueException("Project Title [" + createProjectRequest.getDescription() +
                    "] contains illegal characters");
        }

        String status = null;
        if (createProjectRequest.getStatus() != null) {
            status = createProjectRequest.getStatus();
        }

        Project newProject = new Project();
        newProject.setTitle(createProjectRequest.getTitle());
        newProject.setProjectId(TicketManagementServiceUtils.generateProjectId()
                .concat(newProject.getTitle().trim()));
        newProject.setDescription(createProjectRequest.getDescription());
        newProject.setStatus(status);

        projectDao.saveProject(newProject);

        ProjectModel projectModel = new ProjectModelConverter().toProjectModel(newProject);
        return CreateProjectResult.builder()
                .withProject(projectModel)
                .build();
    }
}
