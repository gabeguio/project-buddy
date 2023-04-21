package com.nashss.se.projectmanagementservice.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ProjectManagementServiceUtils {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"'\\\\]");

    private ProjectManagementServiceUtils() {
    }

    public static boolean isValidString(String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        } else {
            return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
        }
    }

    public static String generateTicketId() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public static String generateProjectId(String projectTitle) {
        return RandomStringUtils.randomAlphanumeric(6) + "-" + transformProjectTitle(projectTitle);
    }

    private static String transformProjectTitle(String projectTitle) {
        return projectTitle.replace(' ', '-');
    }
}

