package com.service.activity;

import com.service.activity.requests.CreateProjectRequest;
import com.service.activity.results.CreateProjectResult;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import com.service.exceptions.InvalidAttributeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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