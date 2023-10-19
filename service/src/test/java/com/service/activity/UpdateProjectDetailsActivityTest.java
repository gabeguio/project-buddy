package com.service.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.service.activity.requests.UpdateProjectDetailsRequest;
import com.service.activity.results.UpdateProjectDetailsResult;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdateProjectDetailsActivityTest {

    private ProjectDao projectDao;
    private UpdateProjectDetailsActivity updateProjectDetailsActivity;

    @BeforeEach
    public void setUp() {
        projectDao = mock(ProjectDao.class);
        updateProjectDetailsActivity = new UpdateProjectDetailsActivity(projectDao);
    }

    @Test
    public void handleRequest_goodRequest_updatesProjectDetails() {
        // Mocking the ProjectDao to return a project with ID "123"
        Project project = new Project();
        project.setProjectId("123");
        project.setTitle("Project Title");
        project.setDescription("Project Description");
        project.setStatus("Project Status");

        when(projectDao.getProject("123")).thenReturn(project);
        when(projectDao.saveProject(project)).thenReturn(project);

        // Creating an UpdateProjectDetailsRequest
        UpdateProjectDetailsRequest updateProjectDetailsRequest = UpdateProjectDetailsRequest.builder()
                .withProjectId("123")
                .withTitle("New Title")
                .withDescription("New Description")
                .withStatus("New Status")
                .build();

        // Calling the handleRequest method
        UpdateProjectDetailsResult result = updateProjectDetailsActivity.handleRequest(updateProjectDetailsRequest);

        // Asserting that the result contains the updated project details
        assertEquals(result.getProject().getTitle(), "New Title");
        assertEquals(result.getProject().getDescription(), "New Description");
        assertEquals(result.getProject().getStatus(), "New Status");
    }
}