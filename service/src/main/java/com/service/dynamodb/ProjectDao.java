package com.service.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.service.dynamodb.models.Project;
import com.service.exceptions.ProjectNotFoundException;

@Singleton
public class ProjectDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public ProjectDao(DynamoDBMapper mapper) {
        this.dynamoDBMapper = mapper;
    }

    public Project getProject(String projectId) {

        Project project = dynamoDBMapper.load(Project.class, projectId);
        if(project == null){
            throw new ProjectNotFoundException();
        }
        return project;

    }

    public Project saveProject(Project project) {
        this.dynamoDBMapper.save(project);
        return project;
    }
    public void deleteProject(Project project){
        this.dynamoDBMapper.delete(project);
    }


    public List<Project> getAllProjects() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        return dynamoDBMapper.scan(Project.class, scanExpression);
    }
}
