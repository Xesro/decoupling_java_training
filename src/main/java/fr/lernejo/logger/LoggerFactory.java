package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(
            new ContextualLogger(new FileLogger("./logs"), name),
            new ContextualLogger(new ConsoleLogger(), name)
        );
    }
}
