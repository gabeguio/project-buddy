package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetMembersRequest;

import com.service.activity.results.GetMembersResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetMembersLambda
        extends LambdaActivityRunner<GetMembersRequest, GetMembersResult>
        implements RequestHandler<LambdaRequest<GetMembersRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetMembersRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetMembersRequest.builder()
                                .withProjectId(path.get("projectId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetMembersActivity().handleRequest(request)
        );
    }
}
