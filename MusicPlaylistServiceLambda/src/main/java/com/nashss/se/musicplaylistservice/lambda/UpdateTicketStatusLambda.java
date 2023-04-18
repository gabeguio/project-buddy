package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.UpdateTicketStatusRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateTicketStatusResult;

public class UpdateTicketStatusLambda extends LambdaActivityRunner<UpdateTicketStatusRequest, UpdateTicketStatusResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateTicketStatusRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateTicketStatusRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateTicketStatusRequest unauthenticatedRequest = input.fromBody(UpdateTicketStatusRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateTicketStatusRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withTicketId(unauthenticatedRequest.getTicketId())
                                    .withStatus(unauthenticatedRequest.getStatus())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateTicketStatusActivity().handleRequest(request)
        );
    }

}
