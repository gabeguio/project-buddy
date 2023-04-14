package com.nashss.se.musicplaylistservice.activity;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.DynamoDbClientProvider;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteProjectActivity {

    private final Logger log = LogManager.getLogger();
    private final ProjectDao projectDao;


    public DeleteProjectActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void handleRequest(String id){
        log.info("Received request to delete project with id {}", id);
        Project project = projectDao.getProject(id);
        projectDao.deleteProject(project);
    }
}
