package com.nashss.se.musicplaylistservice.activity;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteProjectRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteProjectResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.converters.ProjectModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.DynamoDbClientProvider;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.models.ProjectModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteProjectActivity {

    private final Logger log = LogManager.getLogger();
    private final ProjectDao projectDao;


    public DeleteProjectActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public DeleteProjectResult handleRequest(final DeleteProjectRequest deleteProjectRequest){
        log.info("Received request to delete project with id {}", deleteProjectRequest);
        Project project = new Project();
        project.setProjectId(deleteProjectRequest.getProjectId());
        project.setDescription(deleteProjectRequest.getDescription());
        project.setTitle(deleteProjectRequest.getTitle());
        project.setStatus(deleteProjectRequest.getStatus());

        projectDao.deleteProject(project);
        ProjectModel projectModel = new ProjectModelConverter().toProjectModel(project);

        return DeleteProjectResult.builder().withProject(projectModel).build();
    }
}
