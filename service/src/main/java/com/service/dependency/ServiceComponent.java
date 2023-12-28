package com.service.dependency;
import com.service.activity.GetTasksActivity;
import com.service.activity.*;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {
    
    GetProjectActivity provideGetProjectActivity();

    GetTasksActivity provideGetTasksActivity();
    
    GetProjectsActivity provideGetProjectsActivity();

    GetMembersActivity provideGetMembersActivity();
}
