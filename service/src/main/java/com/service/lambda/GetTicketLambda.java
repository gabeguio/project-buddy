package com.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.service.activity.requests.GetTicketRequest;
import com.service.activity.results.GetTicketResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTicketLambda

      extends LambdaActivityRunner<GetTicketRequest, GetTicketResult>
        implements RequestHandler<LambdaRequest<GetTicketRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetTicketRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetTicketRequest.builder()
                    .withProjectId(path.get("projectId")).withTicketId(path.get("ticketId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetTicketActivity().handleRequest(request)
        );
    }

}
