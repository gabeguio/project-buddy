//package com.service.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.service.activity.requests.DeleteProjectRequest;
//import com.service.activity.results.DeleteProjectResult;
//
//public class DeleteProjectLambda extends LambdaActivityRunner<DeleteProjectRequest, DeleteProjectResult>
//        implements RequestHandler<AuthenticatedLambdaRequest<DeleteProjectRequest>, LambdaResponse> {
//    @Override
//    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteProjectRequest> input, Context context) {
//        return super.runActivity(
//                () -> {
//                    DeleteProjectRequest unauthenticatedRequest = input.fromBody(DeleteProjectRequest.class);
//                    return input.fromUserClaims(claims ->
//                            DeleteProjectRequest.builder()
//                                    .withTitle(unauthenticatedRequest.getTitle())
//                                    .withProjectId(unauthenticatedRequest.getProjectId())
//                                    .withDescription(unauthenticatedRequest.getDescription())
//                                    .withStatus(unauthenticatedRequest.getStatus())
//                                    .build());
//                },
//                (request, serviceComponent) ->
//                        serviceComponent.provideDeleteProjectActivity().handleRequest(request)
//        );
//    }
//}
//
