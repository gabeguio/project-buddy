package com.service.dependency;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.GetAllTicketsActivity;
import com.service.activity.GetTicketActivity;

import com.service.activity.*;
import com.service.activity.requests.GetMembersByProjectIdRequest;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    DeleteTicketActivity provideDeleteTicketActivity();

//    DeleteProjectActivity provideDeleteProjectActivity();
    
    GetProjectActivity provideGetProjectActivity();

    CreateTicketActivity provideCreateTicketActivity();
    
    GetTicketActivity provideGetTicketActivity();

    GetAllTicketsActivity provideGetAllTicketsActivity();

//    CreateProjectActivity provideCreateProjectActivity();

    UpdateTicketDetailsActivity provideUpdateTicketActivity();
    
    GetProjectsActivity provideGetProjectsActivity();
    
//    UpdateProjectStatusActivity provideUpdateProjectStatusActivity();
//
//    UpdateProjectDetailsActivity provideUpdateProjectDetailsActivity();

    UpdateTicketStatusActivity provideUpdateTicketStatusActivity();

    GetMembersByProjectIdActivity provideGetMembersByProjectIdActivity();
}
