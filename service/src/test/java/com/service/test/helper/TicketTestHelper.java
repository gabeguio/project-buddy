package com.service.test.helper;

import java.util.List;

import com.service.dynamodb.models.Ticket;
import com.service.models.TicketModel;

public class TicketTestHelper {

    public TicketTestHelper() {}

    public static Ticket generateTicket() {
        Ticket ticket = new Ticket();
        ticket.setProjectId("projectId");
        ticket.setTicketId("ticketId");
        ticket.setTitle("title");
        ticket.setDescription("description");
        ticket.setStatus("status");

        return ticket;
    }

    public static boolean AssertTicketModelEquals(List<Ticket> ticketList, List<TicketModel> ticketModels) {
        for (int i = 0; i < ticketModels.size(); i ++) {
            if (!ticketList.get(i).getProjectId().equals(ticketModels.get(i).getProjectId())) {
                return false;
            }
            if (!ticketList.get(i).getTicketId().equals(ticketModels.get(i).getTicketId())) {
                return false;
            }
            if (!ticketList.get(i).getTitle().equals(ticketModels.get(i).getTitle())) {
                return false;
            }
            if (!ticketList.get(i).getDescription().equals(ticketModels.get(i).getDescription())) {
                return false;
            }
            if (!ticketList.get(i).getStatus().equals(ticketModels.get(i).getStatus())) {
                return false;
            }
        }

        return true;
    }

}
