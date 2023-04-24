package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.DeleteProjectRequest;
import com.nashss.se.projectmanagementservice.activity.results.DeleteProjectResult;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;

import com.nashss.se.projectmanagementservice.models.ProjectModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class DeleteProjectActivityTest {
    @Mock
    private ProjectDao projectDao;

    private DeleteProjectActivity deleteProjectActivity;

    @BeforeEach
    public void setup(){
        initMocks(this);
        deleteProjectActivity = new DeleteProjectActivity(projectDao);
    }

    @Test
    public void handleRequest_withId_deletesProject(){
        //GIVEN
        Project projectToBeDeleted = new Project();
        when(projectDao.getProject("id")).thenReturn(projectToBeDeleted);
        DeleteProjectRequest deleteProjectRequest = DeleteProjectRequest.builder().withProjectId("id")
                .withDescription("expectedDescription")
                .withStatus("expectedStatus")
                .withTitle("expectedTitle")
                .build();
        projectToBeDeleted.setProjectId(deleteProjectRequest.getProjectId());
        projectToBeDeleted.setTitle(deleteProjectRequest.getTitle());
        projectToBeDeleted.setDescription(deleteProjectRequest.getDescription());
        projectToBeDeleted.setStatus(deleteProjectRequest.getStatus());

        //WHEN
        DeleteProjectResult result = deleteProjectActivity.handleRequest(deleteProjectRequest);

        //THEN
        verify(projectDao).deleteProject(projectToBeDeleted);
        ProjectModel expectedProjectModel = ProjectModel.builder()
                .withProjectId(deleteProjectRequest.getProjectId())
                .withTitle(deleteProjectRequest.getTitle())
                .withDescription(deleteProjectRequest.getDescription())
                .withStatus(deleteProjectRequest.getStatus())
                .build();
        assertEquals(expectedProjectModel, result.getProject());

    }
}
