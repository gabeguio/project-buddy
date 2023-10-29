//package com.service.activity;
//
//import com.service.activity.requests.GetProjectRequest;
//import com.service.activity.results.GetProjectResult;
//import com.service.dynamodb.ProjectDao;
//import com.service.dynamodb.models.Project;
//import com.service.ProjectStatus.ProjectStatus;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class GetProjectActivityTest {
//    @Mock
//    private ProjectDao projectDao;
//
//    private GetProjectActivity getProjectActivity;
//
//    @BeforeEach
//    public void setUp() {
//        initMocks(this);
//        getProjectActivity = new GetProjectActivity(projectDao);
//    }
//
//    @Test
//    public void handleRequest_savedProjectFound_returnsProjectModelInResult(){
//        //GIVEN
//        String projectId = "001";
//        String title = "Capstone";
//        String description = "Full-stack web application";
//
//        Project project = new Project();
//        project.setProjectId(projectId);
//        project.setTitle(title);
//        project.setDescription(description);
//        project.setStatus(ProjectStatus.IN_PROGRESS);
//
//        when(projectDao.getProject(projectId)).thenReturn(project);
//
//        GetProjectRequest request = GetProjectRequest.builder().withId(projectId)
//                .build();
//
//        //WHEN
//        GetProjectResult result = getProjectActivity.handleRequest(request);
//
//        //THEN
//        Assertions.assertEquals(projectId, result.getProject().getProjectId());
//        Assertions.assertEquals(title, result.getProject().getTitle());
//        Assertions.assertEquals(description, result.getProject().getDescription());
//        Assertions.assertEquals(ProjectStatus.IN_PROGRESS, result.getProject().getStatus());
//    }
//}
