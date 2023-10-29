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
    private String title;
    private String description;
    private String dueDate;
    private Integer tasksCompleted;
    private Integer totalTasks;
    private String topContributor;

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

    @DynamoDBAttribute(attributeName = "dueDate")
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @DynamoDBAttribute(attributeName = "tasksCompleted")
    public Integer getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(Integer tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    @DynamoDBAttribute(attributeName = "totalTasks")
    public Integer getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }

    @DynamoDBAttribute(attributeName = "topContributor")
    public String getTopContributor() {
        return topContributor;
    }

    public void setTopContributor(String topContributor) {
        this.topContributor = topContributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) && Objects.equals(owner, project.owner) && Objects.equals(dateCreated, project.dateCreated) && Objects.equals(title, project.title) && Objects.equals(description, project.description) && Objects.equals(dueDate, project.dueDate) && Objects.equals(tasksCompleted, project.tasksCompleted) && Objects.equals(totalTasks, project.totalTasks) && Objects.equals(topContributor, project.topContributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, owner, dateCreated, title, description, dueDate, tasksCompleted, totalTasks, topContributor);
    }
}
