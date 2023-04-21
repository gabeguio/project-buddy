package com.nashss.se.projectmanagementservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.projectmanagementservice.activity.requests.DeleteTicketRequest;
import com.nashss.se.projectmanagementservice.activity.results.DeleteTicketResult;

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
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteTicketActivity().handleRequest(request)
        );
    }
}
