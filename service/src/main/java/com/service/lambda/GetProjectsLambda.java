package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetProjectsRequest;
import com.service.activity.results.GetProjectsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProjectsLambda extends LambdaActivityRunner<GetProjectsRequest, GetProjectsResult>
    implements RequestHandler<LambdaRequest<GetProjectsRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetProjectsRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetProjectsRequest.builder()
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetProjectsActivity().handleRequest()
        );
    }
}
