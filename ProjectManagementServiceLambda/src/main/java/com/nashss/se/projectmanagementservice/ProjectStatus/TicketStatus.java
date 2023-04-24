package com.nashss.se.projectmanagementservice.ProjectStatus;

public class TicketStatus {
    public static final String BACK_LOG = "BACK_LOG";
    public static final String IN_PROGRESS = "IN_PROGRESS";
    public static final String COMPLETED = "COMPLETED";

    private TicketStatus() {}

    public static String[] values() {return new String[]{BACK_LOG, IN_PROGRESS, COMPLETED}; }
}
