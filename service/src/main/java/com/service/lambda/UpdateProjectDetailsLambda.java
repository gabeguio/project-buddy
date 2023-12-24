//package com.service.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.service.activity.requests.UpdateProjectDetailsRequest;
//import com.service.activity.results.UpdateProjectDetailsResult;
//
//public class UpdateProjectDetailsLambda extends LambdaActivityRunner<UpdateProjectDetailsRequest, UpdateProjectDetailsResult>
//        implements RequestHandler<AuthenticatedLambdaRequest<UpdateProjectDetailsRequest>, LambdaResponse> {
//    @Override
//    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateProjectDetailsRequest> input, Context context) {
//        return super.runActivity(
//                () -> {
//                    UpdateProjectDetailsRequest unauthenticatedRequest = input.fromBody(UpdateProjectDetailsRequest.class);
//                    return input.fromUserClaims(claims ->
//                            UpdateProjectDetailsRequest.builder()
//                                    .withProjectId(unauthenticatedRequest.getProjectId())
//                                    .withStatus(unauthenticatedRequest.getStatus())
//                                    .withTitle(unauthenticatedRequest.getTitle())
//                                    .withDescription(unauthenticatedRequest.getDescription())
//                                    .build());
//                },
//                (request, serviceComponent) ->
//                        serviceComponent.provideUpdateProjectDetailsActivity().handleRequest(request)
//        );
//    }
//
//
//}
