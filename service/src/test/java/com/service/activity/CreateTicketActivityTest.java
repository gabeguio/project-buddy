//package com.service.activity;
//
//import com.service.dynamodb.TicketDao;
//import com.service.activity.requests.CreateTicketRequest;
//import com.service.activity.results.CreateTicketResult;
//import com.service.dynamodb.models.Ticket;
//import com.service.exceptions.InvalidAttributeValueException;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.MockitoAnnotations.openMocks;
//
//public class CreateTicketActivityTest {
//    @Mock
//    private TicketDao ticketDao;
//
//    private CreateTicketActivity createTicketActivity;
//
//    String expectedProjectId = "expectedProjectId";
//    String expectedTicketTitle = "expectedTicketTitle";
//    String expectedTicketDescription = "test-description";
//    String expectedTicketStatus = "test-status";
//
//    @BeforeEach
//    void setUp() {
//        openMocks(this);
//        createTicketActivity = new CreateTicketActivity(ticketDao);
//    }
//
//    @Test
//    public void handleRequest_createTicketWithRequest_createsAndSavesTicket() {
//        // GIVEN
//        CreateTicketRequest request = CreateTicketRequest.builder()
//                .withProjectId(expectedProjectId)
//                .withtitle(expectedTicketTitle)
//                .withdescription(expectedTicketDescription)
//                .withstatus(expectedTicketStatus)
//                .build();
//
//        // WHEN
//        CreateTicketResult result = createTicketActivity.handleRequest(request);
//
//        // THEN
//        verify(ticketDao).saveTicket(any(Ticket.class));
//
//        assertNotNull(result.getTicketModel().getTicketId());
//        assertEquals(expectedProjectId, result.getTicketModel().getProjectId());
//        assertEquals(expectedTicketTitle, result.getTicketModel().getTitle());
//        assertEquals(expectedTicketDescription, result.getTicketModel().getDescription());
//        assertEquals(expectedTicketStatus, result.getTicketModel().getStatus());
//    }
//
//    @Test
//    public void handleRequest_invalidTitle_throwsInvalidAttributeValueException() {
//        // GIVEN
//        CreateTicketRequest request = CreateTicketRequest.builder()
//                .withProjectId(expectedProjectId)
//                .withtitle("'/expectedTicketTitle/'")
//                .withdescription(expectedTicketDescription)
//                .withstatus(expectedTicketStatus)
//                .build();
//
//        // WHEN + THEN
//        assertThrows(InvalidAttributeValueException.class, () -> createTicketActivity.handleRequest(request));
//    }
//
//    @Test
//    public void handleRequest_invalidDescription_throwsInvalidAttributeValueException() {
//        // GIVEN
//        CreateTicketRequest request = CreateTicketRequest.builder()
//                .withProjectId(expectedProjectId)
//                .withtitle(expectedTicketTitle)
//                .withdescription("'/expectedTicketDescription/'")
//                .withstatus(expectedTicketStatus)
//                .build();
//
//        // WHEN + THEN
//        assertThrows(InvalidAttributeValueException.class, () -> createTicketActivity.handleRequest(request));
//    }
//}