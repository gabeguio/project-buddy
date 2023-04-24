package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.projectmanagementservice.activity.results.UpdateProjectStatusResult;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import com.nashss.se.projectmanagementservice.metrics.MetricsPublisher;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.mockito.InjectMocks;

public class UpdateProjectStatusActivityTest {

    @Mock
    private ProjectDao projectDao;

    @Mock
    private MetricsPublisher metricsPublisher;

    @InjectMocks
    private UpdateProjectStatusActivity updateProjectStatusActivity;

    @BeforeEach
    public void setup() {
        openMocks(this);
        updateProjectStatusActivity = new UpdateProjectStatusActivity(projectDao, metricsPublisher);
    }

    @Test
    public void testHandleRequest() {
        // given
         String projectId = "project-123";
         String oldStatus = "completed";
         String expectedStatus = "in-progress";
         
         UpdateProjectStatusRequest request = UpdateProjectStatusRequest.builder().withStatus(expectedStatus).withProjectId(projectId).build();
         Project project = new Project();
         project.setProjectId(projectId);
         project.setStatus(oldStatus);
         
         when(projectDao.getProject(projectId)).thenReturn(project);
         when(projectDao.saveProject(project)).thenReturn(project);


        // when
        UpdateProjectStatusResult result = updateProjectStatusActivity.handleRequest(request);

        // then
        assertEquals(projectId, result.getProject().getProjectId());
        assertEquals(expectedStatus, result.getProject().getStatus());

    }
}
