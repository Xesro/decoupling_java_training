package fr.lernejo.logger;

public class LoggerFactory {

    static Logger logger = new ConsoleLogger();

    public static Logger getLogger(String name) {
        return logger;
    }

}
