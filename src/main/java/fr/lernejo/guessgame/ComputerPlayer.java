package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    private long upperBound = Long.MAX_VALUE;
    private long lowerBound = 0;
    private long lastResponse;

    @Override
    public long askNextGuess() {
        this.logger.log("quel est l'âge du capitaine ?");
        lastResponse = lowerBound + (upperBound - lowerBound) / 2;
        this.logger.log(String.valueOf(lastResponse));
        return lastResponse;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.lowerBound = this.lastResponse;
        else
            this.upperBound = this.lastResponse;
    }
}
