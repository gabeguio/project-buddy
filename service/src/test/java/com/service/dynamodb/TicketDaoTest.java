//package com.service.dynamodb;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.service.dynamodb.models.Ticket;
//import com.service.test.helper.TicketTestHelper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//public class TicketDaoTest {
//
//    @Mock
//    private DynamoDBMapper dynamoDBMapper;
//
//    private TicketDao ticketDao;
//
//    @BeforeEach
//    public void setup() {
//        initMocks(this);
//        ticketDao = new TicketDao(dynamoDBMapper);
//    }
//
//    @Test
//    void getTicket_withNonexistentProjectIdAndTicketId_loadsTicketByPartitionAndSortKeys() {
//        // GIVEN
//        String projectId = "projectId";
//        String ticketId = "ticketId";
//        Ticket ticket = new Ticket();
//        ticket.setProjectId(projectId);
//        ticket.setTicketId(ticketId);
//        when(dynamoDBMapper.load(Ticket.class, projectId, ticketId)).thenReturn(ticket);
//
//        // WHEN
//        Ticket result = ticketDao.getTicket(projectId, ticketId);
//
//        // THEN
//        verify(dynamoDBMapper).load(Ticket.class, projectId, ticketId);
//        assertEquals(ticket, result,
//                String.format("Expected to receive Ticket returned by DDB (%s), but received %s",
//                        ticket,
//                        result)
//        );
//    }
//
//    @Test
//    public void getAllTickets_callsMapper() {
//        // GIVEN
//        String projectId = "projectId";
//
//        List<Ticket> ticketList = new ArrayList<>();
//        ticketList.add(TicketTestHelper.generateTicket());
//
//        ticketDao = mock(TicketDao.class);
//
//        when(ticketDao.getAllTicketsForProjectId(projectId)).thenReturn(ticketList);
//
//        // WHEN
//        List<Ticket> result = ticketDao.getAllTicketsForProjectId(projectId);
//
//        // THEN
//        verify(ticketDao).getAllTicketsForProjectId(projectId);
//        assertEquals(ticketList, result);
//    }
//}
