package com.service.dynamodb.models;

import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "projects")
public class Project {

    private String projectId;
    private String owner;
    private String dateCreated;
    private String dateLastUpdated;
    private String dateDue;
    private String title;
    private String description;
    private Integer totalCompletedTasks;
    private Integer totalTasks;
    private String topMemberByTasksCompleted;

    @DynamoDBHashKey(attributeName = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @DynamoDBAttribute(attributeName = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @DynamoDBAttribute(attributeName = "dateCreated")
    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @DynamoDBAttribute(attributeName = "dateLastUpdated")
    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    @DynamoDBAttribute(attributeName = "dateDue")
    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
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

    @DynamoDBAttribute(attributeName = "totalCompletedTasks")
    public Integer getTotalCompletedTasks() {
        return totalCompletedTasks;
    }

    public void setTotalCompletedTasks(Integer totalCompletedTasks) {
        this.totalCompletedTasks = totalCompletedTasks;
    }

    @DynamoDBAttribute(attributeName = "totalTasks")
    public Integer getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }

    @DynamoDBAttribute(attributeName = "topMemberByTasksCompleted")
    public String getTopMemberByTasksCompleted() {
        return topMemberByTasksCompleted;
    }

    public void setTopMemberByTasksCompleted(String topMemberByTasksCompleted) {
        this.topMemberByTasksCompleted = topMemberByTasksCompleted;
    }
}
