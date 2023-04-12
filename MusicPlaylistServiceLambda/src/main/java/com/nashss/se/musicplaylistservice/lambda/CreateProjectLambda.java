package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.CreatePlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.CreateProjectRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreatePlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.CreateProjectResult;

public class CreateProjectLambda
        extends LambdaActivityRunner<CreateProjectRequest, CreateProjectResult>
        implements RequestHandler<AuthenticatedLambdaRequest<CreateProjectRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateProjectRequest> input, Context context) {
        return super.runActivity(
            () -> {
                CreateProjectRequest unauthenticatedRequest = input.fromBody(CreateProjectRequest.class);
                return input.fromUserClaims(claims ->
                        CreateProjectRequest.builder()
                                .withProjectId(unauthenticatedRequest.getProjectId())
                                .withTitle(unauthenticatedRequest.getTitle())
                                .withDescription(unauthenticatedRequest.getDescription())
                                .withStatus(unauthenticatedRequest.getStatus())
                                .build());
            },
            (request, serviceComponent) ->
                    serviceComponent.provideCreateProjectActivity().handleRequest(request)
        );
    }
}

