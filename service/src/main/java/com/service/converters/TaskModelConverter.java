package com.service.converters;

import com.service.dynamodb.models.Task;
import com.service.dynamodb.models.User;
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
    public TaskModel toTaskModel(Task task, User user) {
        return TaskModel.builder()
                .withProjectId(task.getProjectId())
                .withTaskId(task.getTaskId())
                .withMemberId(task.getMemberId())
                .withOwner(user.getFirstName() + " " + user.getLastName())
                .withDateCreated(task.getDateCreated())
                .withDateLastUpdated(task.getDateLastUpdated())
                .withDateDue(task.getDateDue())
                .withTitle(task.getTitle())
                .withDescription(task.getDescription())
                .withStatus(task.getStatus())
                .build();
    }

    public List<TaskModel> toTaskModelList(List<Task> tasks, List<User> users) {
        List<TaskModel> taskModels = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            taskModels.add(toTaskModel(tasks.get(i), users.get(i)));
        }
        return taskModels;
    }

}
