package com.service.converters;

import com.service.dynamodb.models.Task;
import com.service.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskModelConverter {

    /**
     * Converts a provided task into a taskModel representation.
     *
     * @param task the task to convert to taskModel
     * @return the converted TaskModel
     */
    public TaskModel toTaskModel(Task task) {
        return TaskModel.builder()
                .withProjectId(task.getProjectId())
                .withTaskId(task.getTaskId())
                .withMemberId(task.getMemberId())
                .withDateCreated(task.getDateCreated())
                .withDateLastUpdated(task.getDateLastUpdated())
                .withDateDue(task.getDateDue())
                .withTitle(task.getTitle())
                .withDescription(task.getDescription())
                .withStatus(task.getStatus())
                .build();
    }

    public List<TaskModel> toTaskModelList(List<Task> tasks) {
        List<TaskModel> taskModels = new ArrayList<>();

        for (Task task : tasks) {
            taskModels.add(toTaskModel(task));
        }

        return taskModels;
    }


}
