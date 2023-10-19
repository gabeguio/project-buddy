package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.UpdateProjectStatusRequest;
import com.service.activity.results.UpdateProjectStatusResult;

public class UpdateProjectStatusLambda extends LambdaActivityRunner<UpdateProjectStatusRequest, UpdateProjectStatusResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateProjectStatusRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateProjectStatusRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateProjectStatusRequest unauthenticatedRequest = input.fromBody(UpdateProjectStatusRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateProjectStatusRequest.builder()
                                    .withProjectId(unauthenticatedRequest.getProjectId())
                                    .withStatus(unauthenticatedRequest.getStatus())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateProjectStatusActivity().handleRequest(request)
        );
    }

}
