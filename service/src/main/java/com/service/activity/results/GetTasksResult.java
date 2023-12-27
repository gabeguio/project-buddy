package com.service.activity.results;

import java.util.ArrayList;
import java.util.List;
import com.service.models.TaskModel;

public class GetTasksResult {

   private final List<TaskModel> taskModelList;

    private GetTasksResult(List<TaskModel> taskModelList) {
        this.taskModelList = taskModelList;
    }

    public List<TaskModel> getTaskModelList() {
        return new ArrayList<>(taskModelList);
    }

    @Override
    public String toString() {
        return "GetTasksResult{" +
            "taskModelList=" + taskModelList +
            '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<TaskModel> taskModelList;

        public Builder withTaskModelList(List<TaskModel> taskModelList) {
            this.taskModelList = new ArrayList<>(taskModelList);
            return this;
        }

        public GetTasksResult build() {
            return new GetTasksResult(taskModelList);
        }
    }


}
