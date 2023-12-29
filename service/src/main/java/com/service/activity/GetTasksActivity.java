package com.service.activity;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.service.activity.requests.GetTasksRequest;
import com.service.activity.results.GetTasksResult;
import com.service.converters.TaskModelConverter;
import com.service.dynamodb.MemberDao;
import com.service.dynamodb.TaskDao;
import com.service.dynamodb.UserDao;
import com.service.dynamodb.models.Member;
import com.service.dynamodb.models.Task;
import com.service.dynamodb.models.User;
import com.service.models.TaskModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTasksActivity {
    private final Logger log = LogManager.getLogger();
    private final TaskDao taskDao;
    private final UserDao userDao;
    private final MemberDao memberDao;

    /**
     * Instantiates a new GetTasksActivity object.
     *
     * @param taskDao taskDao to access the tasks table.
     * @param userDao userDao to access the users table.
     * @param memberDao memberDao to access the members table.
     */
    @Inject
    public GetTasksActivity(TaskDao taskDao, UserDao userDao, MemberDao memberDao) {
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.memberDao = memberDao;
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

        List<User> users = new ArrayList<>();
        for ( Task task : tasks ) {
            String memberId = task.getMemberId();
            Member member = memberDao.queryProjectForMember(getTasksRequest.getProjectId(), memberId);
            users.add(userDao.getUser(member.getUserId()));
        }
        List<TaskModel> taskModelList = taskModelConverter.toTaskModelList(tasks, users);

        return GetTasksResult.builder()
            .withTaskModelList(taskModelList)
            .build();
    }

}
