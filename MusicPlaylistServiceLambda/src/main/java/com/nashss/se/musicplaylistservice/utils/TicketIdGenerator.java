package com.nashss.se.musicplaylistservice.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TicketIdGenerator {

    public static String generateTicketId() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

}
