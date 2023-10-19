package com.service.activity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.service.activity.requests.GetAllProjectsRequest;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import com.service.models.ProjectModel;
import com.service.test.helper.ProjectTestHelper;
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
