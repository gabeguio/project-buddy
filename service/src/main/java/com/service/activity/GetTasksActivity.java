package com.service.activity;

import javax.inject.Inject;
import java.util.List;

import com.service.activity.requests.GetTasksRequest;
import com.service.activity.results.GetTasksResult;
import com.service.converters.TaskModelConverter;
import com.service.dynamodb.TaskDao;
import com.service.dynamodb.models.Task;
import com.service.models.TaskModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTasksActivity {
    private final Logger log = LogManager.getLogger();
    private final TaskDao taskDao;

    /**
     * Instantiates a new GettasksActivity object.
     *
     * @param taskDao taskDao to access the tasks table.
     */
    @Inject
    public GetTasksActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * This method handles the incoming request by retrieving the tasks from the database.
     * <p>
     * It then returns the tasks list.
     * <p>
     * If the task does not exist, this should throw a taskNotFound.
     *
     * @param getTasksRequest request object containing the project ID
     * @return GetTasksResult result object containing the taskModel list of API defined {@link TaskModel}s
     */
    public GetTasksResult handleRequest(final GetTasksRequest getTasksRequest) {
        log.info("Received GetTasksRequest {}", getTasksRequest);
        TaskModelConverter taskModelConverter = new TaskModelConverter();

        List<Task> tasks = taskDao.getTasksForProjectId(getTasksRequest.getProjectId());
        List<TaskModel> taskModelList = taskModelConverter.toTaskModelList(tasks);

        return GetTasksResult.builder()
            .withTaskModelList(taskModelList)
            .build();
    }

}
