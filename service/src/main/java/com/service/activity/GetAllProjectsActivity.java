package com.service.activity;

import javax.inject.Inject;
import java.util.List;

import com.service.activity.results.GetAllProjectsResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.models.ProjectModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAllProjectsActivity {
    private final Logger log = LogManager.getLogger();
    public ProjectDao projectDao;

    @Inject
    public GetAllProjectsActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public GetAllProjectsResult handleRequest() {
        log.info("Received GetAllProjectsRequest {}");
        ProjectModelConverter modelConverter = new ProjectModelConverter();

        List<ProjectModel> projectModels = modelConverter.toProjectModelList(projectDao.getAllProjects());

        return GetAllProjectsResult.builder()
            .withProjectList(projectModels)
            .build();
    }
}
