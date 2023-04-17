package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.AddSongToPlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.AddSongToPlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.DeleteTicketResult;

public class DeleteTicketLambda extends LambdaActivityRunner<DeleteTicketRequest, DeleteTicketResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeleteTicketRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteTicketRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    DeleteTicketRequest unauthenticatedRequest = input.fromBody(DeleteTicketRequest.class);
                    return input.fromUserClaims(claims ->
                            DeleteTicketRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withTicketId(unauthenticatedRequest.getTicketId())
                                    .withStatus(unauthenticatedRequest.getStatus())
                                    .withDescription(unauthenticatedRequest.getDescription())
                                    .withTitle(unauthenticatedRequest.getTitle())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteTicketActivity().handleRequest(request)
        );
    }
}
