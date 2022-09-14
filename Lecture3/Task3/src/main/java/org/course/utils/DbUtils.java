package org.course.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class DbUtils {
    public static final int ID_LENGTH = 10;
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
