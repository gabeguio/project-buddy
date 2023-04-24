package com.nashss.se.projectmanagementservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.projectmanagementservice.activity.requests.UpdateProjectStatusRequest;
import com.nashss.se.projectmanagementservice.activity.results.UpdateProjectStatusResult;

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
