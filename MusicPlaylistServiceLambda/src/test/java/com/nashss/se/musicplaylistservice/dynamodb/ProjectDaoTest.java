package com.nashss.se.musicplaylistservice.dynamodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.metrics.MetricsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProjectDaoTest {

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private ProjectDao projectDao;

    @BeforeEach
    public void setup() {
        initMocks(this);
        projectDao = new ProjectDao(dynamoDBMapper);
    }

    @Test
    public void getProject_withProjectId_callsMapperWithPartitionKey() {
        // GIVEN
        String projectId = "projectId";
        when(dynamoDBMapper.load(Project.class, projectId)).thenReturn(new Project());

        // WHEN
        Project project = projectDao.getProject(projectId);

        // THEN
        assertNotNull(project);
        verify(dynamoDBMapper).load(Project.class, projectId);
    }

    @Test
    public void saveProject_callsMapperWithProject() {
        // GIVEN
        Project project = new Project();

        // WHEN
        Project result = projectDao.saveProject(project);

        // THEN
        verify(dynamoDBMapper).save(project);
        assertEquals(project, result);
    }


}