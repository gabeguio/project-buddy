package com.nashss.se.musicplaylistservice.activity.results;

import java.util.ArrayList;
import java.util.List;

import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.TicketModel;

public class GetAllTicketsResult {

   private final List<TicketModel> ticketModels;

    private GetAllTicketsResult(List<TicketModel> ticketModels) {
        this.ticketModels = ticketModels;
    }

    public List<TicketModel> getTicketList() {
        return new ArrayList<>(ticketModels);
    }

    @Override
    public String toString() {
        return "GetAllTicketsResult{" +
            "ticketModels=" + ticketModels +
            '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<TicketModel> ticketList;

        public Builder withTicketList(List<TicketModel> ticketList) {
            this.ticketList = new ArrayList<>(ticketList);
            return this;
        }

        public GetAllTicketsResult build() {
            return new GetAllTicketsResult(ticketList);
        }
    }


}
