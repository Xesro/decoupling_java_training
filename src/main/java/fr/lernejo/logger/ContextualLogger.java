package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class ContextualLogger implements Logger{

    private Logger delegateLogger;
    private String callerClass;

    public ContextualLogger(Logger logger, String callerClass) {
        delegateLogger = logger;
        this.callerClass = callerClass;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + callerClass + " " + message);
    }
}
