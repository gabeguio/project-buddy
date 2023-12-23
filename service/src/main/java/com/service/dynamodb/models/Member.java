package com.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@DynamoDBTable(tableName = "members")
public class Member {
    private String projectId;
    private String userId;
    private String memberId;
    private String dateJoined;
    private String role;
    private Set<String> currentTasks;
    private Set<String> tasksCompleted;

    @DynamoDBHashKey(attributeName = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @DynamoDBRangeKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "memberId")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @DynamoDBAttribute(attributeName = "dateJoined")
    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    @DynamoDBAttribute(attributeName = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @DynamoDBAttribute(attributeName = "currentTasks")
    public Set<String> getCurrentTasks() {
        if (null == currentTasks) {
            return null;
        }

        return new HashSet<>(currentTasks);
    }

    public void setCurrentTasks(Set<String> currentTasks) {
        if (null == currentTasks) {
            this.currentTasks = null;
        } else {
            this.currentTasks = new HashSet<>(currentTasks);
        }

        this.currentTasks = currentTasks;
    }

    @DynamoDBAttribute(attributeName = "tasksCompleted")
    public Set<String> getTasksCompleted() {
        if (null == tasksCompleted) {
            return null;
        }

        return new HashSet<>(tasksCompleted);
    }

    public void setTasksCompleted(Set<String> tasksCompleted) {
        if (null == tasksCompleted) {
            this.tasksCompleted = null;
        } else {
            this.tasksCompleted = new HashSet<>(tasksCompleted);
        }

        this.tasksCompleted = tasksCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(projectId, member.projectId) 
            && Objects.equals(userId, member.userId) 
            && Objects.equals(memberId, member.memberId) 
            && Objects.equals(dateJoined, member.dateJoined) 
            && Objects.equals(role, member.role) 
            && Objects.equals(currentTasks, member.currentTasks) 
            && Objects.equals(tasksCompleted, member.tasksCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, memberId, dateJoined, role, currentTasks, tasksCompleted);
    }
}

