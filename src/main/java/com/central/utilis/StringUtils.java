package com.central.utilis;

import com.central.utilis.logger.ILogger;

public class StringUtils implements ILogger {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
