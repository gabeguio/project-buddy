package com.service.activity.results;

import com.service.models.TicketModel;

public class UpdateTicketDetailsResult {

    private final TicketModel ticketModel;

    private UpdateTicketDetailsResult(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    public TicketModel getTicketModel() {
        return ticketModel;
    }

    @Override
    public String toString() {
        return "UpdateTicketResult{" +
                "ticketModel=" + ticketModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private TicketModel ticketModel;

        public Builder withTicketModel(TicketModel ticketModel) {
            this.ticketModel = ticketModel;
            return this;
        }

        public UpdateTicketDetailsResult build() {
            return new UpdateTicketDetailsResult(ticketModel);
        }
    }
}