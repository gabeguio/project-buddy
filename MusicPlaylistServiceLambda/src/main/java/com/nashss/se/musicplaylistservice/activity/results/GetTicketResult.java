package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.TicketModel;


public class GetTicketResult {
    private final TicketModel ticketModel;

    private GetTicketResult(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    public TicketModel getTicketModel() {
        return ticketModel;
    }

    @Override
    public String toString() {
        return "GetTicketResult{" +
            "ticketModel=" + ticketModel +
            '}';
    }
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TicketModel ticketModel;

        public Builder withTicket(TicketModel ticketModel) {
            this.ticketModel = ticketModel;
            return this;
        }

        public GetTicketResult build() {return new GetTicketResult(ticketModel); }
    }


}
