package com.service.activity;

import com.service.activity.requests.GetProjectsRequest;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.models.Project;
import com.service.models.ProjectModel;
import com.service.test.helper.ProjectTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetProjectsActivityTest {

    @Mock
    private ProjectDao projectDao;

    private GetProjectsActivity getProjectsActivity;

    @BeforeEach
    void setup() {
        openMocks(this);
        getProjectsActivity = new GetProjectsActivity(projectDao);
    }

//    @Test
//    void handleRequest_ticketExists_returnsTicket() {
//        // GIVEN
//        Project project1 = ProjectTestHelper.generateProject();
//        Project project2 = ProjectTestHelper.generateProject();
//
//        List<Project> projectList = new ArrayList<>();
//        projectList.add(project1);
//        projectList.add(project2);
//
//        GetProjectsRequest.builder()
//                .build();
//
//        when(projectDao.getProjects()).thenReturn(projectList);
//
//        // WHEN
//        List<ProjectModel> returnedProjects = getProjectsActivity.handleRequest().getProjectList();
//
//        // THEN
//        Assertions.assertTrue(ProjectTestHelper.AssertProjectModelEquals(projectList, returnedProjects));
//    }
}

