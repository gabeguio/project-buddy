//package com.service.activity;
//
//import com.service.activity.requests.UpdateProjectDetailsRequest;
//import com.service.activity.results.UpdateProjectDetailsResult;
//import com.service.converters.ProjectModelConverter;
//import com.service.dynamodb.ProjectDao;
//import com.service.dynamodb.models.Project;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.inject.Inject;
//
//public class UpdateProjectDetailsActivity {
//
//    private final Logger log = LogManager.getLogger();
//
//    private final ProjectDao projectDao;
//    @Inject
//    public UpdateProjectDetailsActivity(ProjectDao projectDao) {
//        this.projectDao = projectDao;
//    }
//
//    public UpdateProjectDetailsResult handleRequest(final UpdateProjectDetailsRequest updateProjectDetailsRequest) {
//        log.info("Received UpdateProjectDetailsRequest {}", updateProjectDetailsRequest);
//
//        Project project = projectDao.getProject(updateProjectDetailsRequest.getProjectId());
//
////        project.setStatus(updateProjectDetailsRequest.getStatus());
//        project.setDescription(updateProjectDetailsRequest.getDescription());
//        project.setTitle(updateProjectDetailsRequest.getTitle());
//
//        project = projectDao.saveProject(project);
//
//        return UpdateProjectDetailsResult.builder().withProject(new ProjectModelConverter()
//                        .toProjectModel(project))
//                .build();
//
//    }
//
//
//}
