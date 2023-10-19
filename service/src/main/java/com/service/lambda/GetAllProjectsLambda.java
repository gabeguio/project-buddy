package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetAllProjectsRequest;
import com.service.activity.results.GetAllProjectsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAllProjectsLambda extends LambdaActivityRunner<GetAllProjectsRequest, GetAllProjectsResult>
    implements RequestHandler<LambdaRequest<GetAllProjectsRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllProjectsRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetAllProjectsRequest.builder()
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetAllProjectsActivity().handleRequest()
        );
    }
}
