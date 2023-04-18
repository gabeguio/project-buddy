package com.nashss.se.musicplaylistservice.activity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.nashss.se.musicplaylistservice.activity.requests.GetAllProjectsRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetAllTicketsRequest;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.TicketDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.dynamodb.models.Ticket;
import com.nashss.se.musicplaylistservice.models.ProjectModel;
import com.nashss.se.musicplaylistservice.models.TicketModel;
import com.nashss.se.musicplaylistservice.test.helper.ProjectTestHelper;
import com.nashss.se.musicplaylistservice.test.helper.TicketTestHelper;
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
