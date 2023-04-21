package com.nashss.se.projectmanagementservice.activity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.nashss.se.projectmanagementservice.activity.requests.GetAllProjectsRequest;
import com.nashss.se.projectmanagementservice.dynamodb.ProjectDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import com.nashss.se.projectmanagementservice.models.ProjectModel;
import com.nashss.se.projectmanagementservice.test.helper.ProjectTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GetAllProjectsActivityTest {

    @Mock
    private ProjectDao projectDao;

    private GetAllProjectsActivity getAllProjectsActivity;

    @BeforeEach
    void setup() {
        openMocks(this);
        getAllProjectsActivity = new GetAllProjectsActivity(projectDao);
    }

    @Test
    void handleRequest_ticketExists_returnsTicket() {
        // GIVEN
        Project project1 = ProjectTestHelper.generateProject();
        Project project2 = ProjectTestHelper.generateProject();

       List<Project> projectList = new ArrayList<>();
        projectList.add(project1);
        projectList.add(project2);

        GetAllProjectsRequest.builder()
            .build();

        when(projectDao.getAllProjects()).thenReturn(projectList);

        // WHEN
        List<ProjectModel> returnedProjects = getAllProjectsActivity.handleRequest().getProjectList();

        // THEN
        Assertions.assertTrue(ProjectTestHelper.AssertProjectModelEquals(projectList, returnedProjects));
    }
}
