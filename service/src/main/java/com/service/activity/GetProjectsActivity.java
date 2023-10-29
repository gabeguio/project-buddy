package com.service.activity;

import javax.inject.Inject;
import java.util.List;

import com.service.activity.results.GetProjectsResult;
import com.service.converters.ProjectModelConverter;
import com.service.dynamodb.ProjectDao;
import com.service.models.ProjectModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProjectsActivity {
    private final Logger log = LogManager.getLogger();
    public ProjectDao projectDao;

    @Inject
    public GetProjectsActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public GetProjectsResult handleRequest() {
        log.info("Received GetProjectsRequest {}");
        ProjectModelConverter modelConverter = new ProjectModelConverter();

        List<ProjectModel> projectModels = modelConverter.toProjectModelList(projectDao.getProjects());

        return GetProjectsResult.builder()
            .withProjectList(projectModels)
            .build();
    }
}
