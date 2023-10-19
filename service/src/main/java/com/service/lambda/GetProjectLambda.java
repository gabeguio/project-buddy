package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetProjectRequest;
import com.service.activity.results.GetProjectResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProjectLambda extends LambdaActivityRunner<GetProjectRequest, GetProjectResult>
        implements RequestHandler<LambdaRequest<GetProjectRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetProjectRequest> input, Context context){
        log.info("handleRequest");
        return super.runActivity(
                () -> input.fromPath(path -> GetProjectRequest.builder().withId(path.get("projectId")).build()),
                        (request, serviceComponent) ->
                                serviceComponent.provideGetProjectActivity().handleRequest(request)

                );
    }
}
