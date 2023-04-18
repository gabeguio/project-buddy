package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.TicketModel;

public class UpdateTicketStatusResult {

    private final TicketModel ticket;

    private UpdateTicketStatusResult(TicketModel ticket){
        this.ticket = ticket;
    }

    public TicketModel getTicket(){
        return ticket;
    }

    @Override
    public String toString(){
        return "UpdateTicketStatus{" + "ticket=" +
                ticket + '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private TicketModel ticket;

        public Builder withTicket(TicketModel ticket){
            this.ticket = ticket;
            return this;
        }

        public UpdateTicketStatusResult build(){
            return new UpdateTicketStatusResult(ticket);
        }
    }
}
