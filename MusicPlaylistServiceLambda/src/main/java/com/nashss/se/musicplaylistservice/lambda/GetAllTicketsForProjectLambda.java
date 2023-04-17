package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.GetAllTicketsRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetAllTicketsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAllTicketsForProjectLambda
    extends LambdaActivityRunner<GetAllTicketsRequest, GetAllTicketsResult>
    implements RequestHandler<LambdaRequest<GetAllTicketsRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllTicketsRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetAllTicketsRequest.builder()
                    .withId(path.get("projectId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetAllTicketsActivity().handleRequest(request)
        );
    }
}
