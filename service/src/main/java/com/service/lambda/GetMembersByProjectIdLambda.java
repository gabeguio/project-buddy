package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetMembersByProjectIdRequest;

import com.service.activity.results.GetMembersByProjectIdResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetMembersByProjectIdLambda
        extends LambdaActivityRunner<GetMembersByProjectIdRequest, GetMembersByProjectIdResult>
        implements RequestHandler<LambdaRequest<GetMembersByProjectIdRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetMembersByProjectIdRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetMembersByProjectIdRequest.builder()
                                .withProjectId(path.get("projectId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetMembersByProjectIdActivity().handleRequest(request)
        );
    }
}
