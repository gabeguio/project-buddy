package com.nashss.se.musicplaylistservice.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;

@Singleton
public class ProjectDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public ProjectDao(DynamoDBMapper mapper) {
        this.dynamoDBMapper = mapper;
    }

    public Project getProject(String projectId) {
        Project project = dynamoDBMapper.load(Project.class, projectId);

        return project;

    }

    public Project saveProject(Project project) {
        this.dynamoDBMapper.save(project);
        return project;
    }
}
