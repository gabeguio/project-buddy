package com.nashss.se.projectmanagementservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.projectmanagementservice.activity.requests.CreateProjectRequest;
import com.nashss.se.projectmanagementservice.activity.results.CreateProjectResult;

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

