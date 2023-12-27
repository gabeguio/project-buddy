package com.service.activity;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.service.activity.results.GetProjectsResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.dynamodb.UserDao;
import com.service.dynamodb.models.Project;
import com.service.dynamodb.models.User;
import com.service.models.ProjectModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProjectsActivity {
    private final Logger log = LogManager.getLogger();
    private ProjectDao projectDao;
    private UserDao userDao;


    @Inject
    public GetProjectsActivity(ProjectDao projectDao, UserDao userDao) {
        this.projectDao = projectDao;
        this.userDao = userDao;
    }

    public GetProjectsResult handleRequest() {
        log.info("Received GetProjectsRequest {}");
        ProjectModelConverter modelConverter = new ProjectModelConverter();

        List<Project> projects = projectDao.getProjects();
        List<User> users = new ArrayList<>();
        for ( Project project : projects ) {
            users.add(userDao.getUser(project.getOwner()));
        }

        List<ProjectModel> projectModelList = modelConverter.toProjectModelList(projects, users);

        return GetProjectsResult.builder()
            .withProjectModelList(projectModelList)
            .build();
    }
}
