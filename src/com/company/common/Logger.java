package com.company.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Логгер
 * @author Alexander Kanunnikov
 */

public class Logger {

    private SimpleDateFormat dateFormat;

    public Logger() {
        this("HH:mm:ss.SSS");
    }

    public Logger(String dateFormat) {
         this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    public void logf(String message, Object ...args) {
        log(String.format(message, args));
    }

    public void log(String message) {
        System.out.printf("[%s] %s\n", dateFormat.format(new Date()), message);
    }

}