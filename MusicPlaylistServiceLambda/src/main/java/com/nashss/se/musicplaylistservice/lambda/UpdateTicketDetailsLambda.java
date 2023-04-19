package com.nashss.se.musicplaylistservice.lambda;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketDetailsRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketDetailsResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateTicketDetailsLambda
        extends LambdaActivityRunner<UpdateTicketDetailsRequest, UpdateTicketDetailsResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateTicketDetailsRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateTicketDetailsRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateTicketDetailsRequest unauthenticatedRequest = input.fromBody(UpdateTicketDetailsRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateTicketDetailsRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withTicketId(unauthenticatedRequest.getTicketId())
                                    .withTitle(unauthenticatedRequest.getTitle())
                                    .withDescription(unauthenticatedRequest.getDescription())
                                    .withStatus(unauthenticatedRequest.getStatus())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateTicketActivity().handleRequest(request)
        );
    }
}