package com.nashss.se.projectmanagementservice.dependency;

import com.nashss.se.projectmanagementservice.activity.*;

import com.nashss.se.projectmanagementservice.activity.GetAllTicketsActivity;
import com.nashss.se.projectmanagementservice.activity.GetTicketActivity;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    DeleteTicketActivity provideDeleteTicketActivity();

    DeleteProjectActivity provideDeleteProjectActivity();
    
    GetProjectActivity provideGetProjectActivity();

    CreateTicketActivity provideCreateTicketActivity();
    
    GetTicketActivity provideGetTicketActivity();

    GetAllTicketsActivity provideGetAllTicketsActivity();

    CreateProjectActivity provideCreateProjectActivity();

    UpdateTicketDetailsActivity provideUpdateTicketActivity();
    
    GetAllProjectsActivity provideGetAllProjectsActivity();
    
    UpdateProjectStatusActivity provideUpdateProjectStatusActivity();

    UpdateProjectDetailsActivity provideUpdateProjectDetailsActivity();

    UpdateTicketStatusActivity provideUpdateTicketStatusActivity();

}
