package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{


    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public long askNextGuess() {
        this.logger.log("quel est l'âge du capitaine ?");
        return this.scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.logger.log("higher");
        else
            this.logger.log("lower");
    }
}
