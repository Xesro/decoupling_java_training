package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(
            new ContextualLogger(
                name, new FilteredLogger(new FileLogger("./logs"), message -> message.contains("simulation"))
            ),
            new ContextualLogger(name, new ConsoleLogger())
        );
    }
}
