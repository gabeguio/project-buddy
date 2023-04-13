package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.GetPlaylistRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetTicketRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetPlaylistResult;
import com.nashss.se.musicplaylistservice.activity.results.GetTicketResult;
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
                    .withId(path.get("projectId"))
                    .withTicketId(path.get("ticketId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetTicketActivity().handleRequest(request)
        );
    }

}
