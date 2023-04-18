package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateProjectStatusResult;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.MockitoAnnotations.openMocks;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

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
