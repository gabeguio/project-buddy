package com.nashss.se.projectmanagementservice.activity.results;

import com.nashss.se.projectmanagementservice.models.TicketModel;

public class DeleteTicketResult {
    private final TicketModel ticket;

    private DeleteTicketResult(TicketModel ticket){
        this.ticket = ticket;
    }

    public TicketModel getTicket(){
        return ticket;
    }

    @Override
    public String toString(){
        return "DeleteTicketResult{" + "ticket=" + ticket + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private TicketModel ticket;


    public Builder withTicket(TicketModel ticket){
        this.ticket = ticket;
        return this;
    }

    public DeleteTicketResult build() {
        return new DeleteTicketResult(ticket);
        }
    }
}
