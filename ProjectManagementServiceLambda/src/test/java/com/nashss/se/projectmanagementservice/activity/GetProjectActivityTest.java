package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.GetProjectRequest;
import com.nashss.se.projectmanagementservice.activity.results.GetProjectResult;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static com.nashss.se.projectmanagementservice.ProjectStatus.ProjectStatus.IN_PROGRESS;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProjectActivityTest {
    @Mock
    private ProjectDao projectDao;

    private GetProjectActivity getProjectActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        getProjectActivity = new GetProjectActivity(projectDao);
    }

    @Test
    public void handleRequest_savedProjectFound_returnsProjectModelInResult(){
        //GIVEN
        String projectId = "001";
        String title = "Capstone";
        String description = "Full-stack web application";

        Project project = new Project();
        project.setProjectId(projectId);
        project.setTitle(title);
        project.setDescription(description);
        project.setStatus(IN_PROGRESS);

        when(projectDao.getProject(projectId)).thenReturn(project);

        GetProjectRequest request = GetProjectRequest.builder().withId(projectId)
                .build();

        //WHEN
        GetProjectResult result = getProjectActivity.handleRequest(request);

        //THEN
        assertEquals(projectId, result.getProject().getProjectId());
        assertEquals(title, result.getProject().getTitle());
        assertEquals(description, result.getProject().getDescription());
        assertEquals(IN_PROGRESS, result.getProject().getStatus());
    }
}
