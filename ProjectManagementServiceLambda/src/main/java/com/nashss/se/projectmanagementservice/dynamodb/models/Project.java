package com.nashss.se.projectmanagementservice.dynamodb.models;

import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "projects")
public class Project {

    private String projectId;
    private String title;
    private String description;
    private String status;

    @DynamoDBHashKey(attributeName = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {this.status = status;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) && Objects.equals(title, project.title) &&
            Objects.equals(description, project.description) && Objects.equals(status, project.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, title, description, status);
    }


}
