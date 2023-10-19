package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.DeleteTicketRequest;
import com.service.activity.results.DeleteTicketResult;

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
