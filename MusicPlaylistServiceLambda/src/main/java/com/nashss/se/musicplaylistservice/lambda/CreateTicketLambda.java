package com.nashss.se.musicplaylistservice.lambda;

import com.nashss.se.musicplaylistservice.activity.requests.CreateTicketRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.results.CreateTicketResult;

public class CreateTicketLambda
        extends LambdaActivityRunner<CreateTicketRequest, CreateTicketResult>
        implements RequestHandler<AuthenticatedLambdaRequest<CreateTicketRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateTicketRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    CreateTicketRequest unauthenticatedRequest = input.fromBody(CreateTicketRequest.class);
                    return input.fromUserClaims(claims ->
                            CreateTicketRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withtitle(unauthenticatedRequest.getTitle())
                                    .withdescription(unauthenticatedRequest.getDescription())
                                    .withstatus(unauthenticatedRequest.getStatus())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideCreateTicketActivity().handleRequest(request)
        );
    }
}

