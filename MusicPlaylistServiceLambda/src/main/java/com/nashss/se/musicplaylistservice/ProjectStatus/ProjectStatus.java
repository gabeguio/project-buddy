package com.nashss.se.musicplaylistservice.ProjectStatus;

public class ProjectStatus {
        public static final String BACK_LOG = "BACK_LOG";
        public static final String IN_PROGRESS = "IN_PROGRESS";
        public static final String COMPLETED = "COMPLETED";

        private ProjectStatus() {}

    public static String[] values() {return new String[]{BACK_LOG, IN_PROGRESS, COMPLETED}; }
    }

