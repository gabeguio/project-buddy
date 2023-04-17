package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreatePlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.CreateProjectRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreatePlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.CreateProjectResult;
import com.nashss.se.musicplaylistservice.dynamodb.PlaylistDao;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateProjectActivityTest {
    @Mock
    private ProjectDao projectDao;

    private CreateProjectActivity createProjectActivity;

    @BeforeEach
    void setUp() {
        openMocks(this);
        createProjectActivity = new CreateProjectActivity(projectDao);
    }

    @Test
    public void handleRequest_withStatus_createsAndSavesProject() {
        // GIVEN
        String expectedTitle = "expectedTitle";
        String expectedDescription = "expectedDescription";
        String expectedStatus = "expectedStatus";

        CreateProjectRequest request = CreateProjectRequest.builder()
                                            .withTitle(expectedTitle)
                                            .withDescription(expectedDescription)
                                            .withStatus(expectedStatus)
                                            .build();

        // WHEN
        CreateProjectResult result = createProjectActivity.handleRequest(request);

        // THEN
        verify(projectDao).saveProject(any(Project.class));

        assertNotNull(result.getProject().getProjectId());
        assertEquals(expectedTitle, result.getProject().getTitle());
        assertEquals(expectedDescription, result.getProject().getDescription());
        assertEquals(expectedStatus, result.getProject().getStatus());
    }

    @Test
    public void handleRequest_noTickets_createsAndSavesPlaylistWithoutTickets() {
        // GIVEN
        String expectedTitle = "expectedTitle";
        String expectedDescription = "expectedDescription";
        String expectedStatus = "expectedStatus";

        CreateProjectRequest request = CreateProjectRequest.builder()
                                            .withTitle(expectedTitle)
                                            .withDescription(expectedDescription)
                                            .withStatus(expectedStatus)
                                            .build();

        // WHEN
        CreateProjectResult result = createProjectActivity.handleRequest(request);

        // THEN
        verify(projectDao).saveProject(any(Project.class));

        assertNotNull(result.getProject().getProjectId());
        assertEquals(expectedTitle, result.getProject().getTitle());
        assertEquals(expectedDescription, result.getProject().getDescription());
        assertEquals(expectedStatus, result.getProject().getStatus());
    }

    @Test
    public void handleRequest_MissingStatus_throwsInvalidAttributeValueException() {
        // GIVEN
        CreateProjectRequest request = CreateProjectRequest.builder()
                                            .withTitle("I'm illegal")
                                            .withDescription("customerId")
                                            .build();

        // WHEN + THEN
        assertThrows(InvalidAttributeValueException.class, () -> createProjectActivity.handleRequest(request));
    }
}