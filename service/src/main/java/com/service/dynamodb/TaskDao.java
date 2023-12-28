package com.service.dynamodb;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.service.dynamodb.models.Task;
import com.service.exceptions.TaskNotFoundException;

public class TaskDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public TaskDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Task getTask(String projectId, String taskId) {
        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }

        if (taskId == null) {
            throw new IllegalArgumentException("passed in taskId is null");
        }

        Task task = this.dynamoDBMapper.load(Task.class, projectId, taskId);

        if(task == null) {
            throw new TaskNotFoundException("Task not found for requested projectId");
        }

        return task;
    }

    public Task saveTask(Task task) {
        this.dynamoDBMapper.save(task);
        return task;
    }

    public List<Task> getTasksForProjectId(String projectId) {

        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":projectId", new AttributeValue().withS(projectId));

        DynamoDBQueryExpression<Task> queryExpression = new DynamoDBQueryExpression<Task>()
            .withKeyConditionExpression("projectId = :projectId")
            .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Task> taskList = dynamoDBMapper.query(Task.class, queryExpression);

        if(taskList == null) {
            throw new TaskNotFoundException("Tasks not found for requested projectId");
        }

        return taskList;
    }

    public void deleteTask(Task task){
        this.dynamoDBMapper.delete(task);
    }
}
