package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetTasksRequest;
import com.service.activity.results.GetTasksResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTasksLambda
    extends LambdaActivityRunner<GetTasksRequest, GetTasksResult>
    implements RequestHandler<LambdaRequest<GetTasksRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetTasksRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetTasksRequest.builder()
                    .withProjectId(path.get("projectId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetTasksActivity().handleRequest(request)
        );
    }
}
