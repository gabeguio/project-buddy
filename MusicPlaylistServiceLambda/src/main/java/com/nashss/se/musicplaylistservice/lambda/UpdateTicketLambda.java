package com.nashss.se.musicplaylistservice.lambda;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateTicketLambda
        extends LambdaActivityRunner<UpdateTicketRequest, UpdateTicketResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateTicketRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateTicketRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateTicketRequest unauthenticatedRequest = input.fromBody(UpdateTicketRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateTicketRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withticketId(unauthenticatedRequest.getTicketId())
                                    .withtitle(unauthenticatedRequest.getTitle())
                                    .withdescription(unauthenticatedRequest.getDescription())
                                    .withstatus(unauthenticatedRequest.getStatus())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateTicketActivity().handleRequest(request)
        );
    }
}