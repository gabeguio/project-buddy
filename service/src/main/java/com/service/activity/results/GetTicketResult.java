package com.service.activity.results;

import com.service.models.TicketModel;


public class GetTicketResult {
    private final TicketModel ticket;

    private GetTicketResult(TicketModel ticketModel) {
        this.ticket = ticketModel;
    }

    public TicketModel getTicketModel() {
        return ticket;
    }

    @Override
    public String toString() {
        return "GetTicketResult{" +
            "ticketModel=" + ticket +
            '}';
    }
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TicketModel ticket;

        public Builder withTicket(TicketModel ticket) {
            this.ticket = ticket;
            return this;
        }

        public GetTicketResult build() {
            return new GetTicketResult(ticket); }
    }


}
