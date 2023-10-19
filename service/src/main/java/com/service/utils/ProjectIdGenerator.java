package com.service.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class ProjectIdGenerator {

    public static String generateProjectId(String projecTitle) {
        return RandomStringUtils.randomAlphanumeric(6) + "-" + transformProjectTitle(projecTitle);
    }

    private static String transformProjectTitle(String projectTitle) {
        return projectTitle.replace(' ', '-');

    }
}
