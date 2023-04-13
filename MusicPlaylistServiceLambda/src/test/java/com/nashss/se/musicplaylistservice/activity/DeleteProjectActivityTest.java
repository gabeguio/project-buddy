package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreatePlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreatePlaylistResult;
import com.nashss.se.musicplaylistservice.dynamodb.PlaylistDao;
import com.nashss.se.musicplaylistservice.dynamodb.ProjectDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Project;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.MockitoAnnotations.openMocks;

public class DeleteProjectActivityTest {
    @Mock
    private ProjectDao projectDao;

    private DeleteProjectActivity deleteProjectActivity;

    @BeforeEach
    public void setup(){
        initMocks(this);
        deleteProjectActivity = new DeleteProjectActivity(projectDao);
    }

    @Test
    public void handleRequest_withId_deletesProject(){
        //GIVEN
        String id = "expectedId";
        Project projectToBeDeleted = new Project();
        projectToBeDeleted.setProjectId(id);
        when(projectDao.getProject(id)).thenReturn(projectToBeDeleted);

        //WHEN
        deleteProjectActivity.handleRequest(id);

        //THEN
        verify(projectDao).deleteProject(projectToBeDeleted);
    }
}
