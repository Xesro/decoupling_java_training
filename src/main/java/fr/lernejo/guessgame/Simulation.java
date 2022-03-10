package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private long maxIterations;

    public Simulation(Player player, long maxIterations) {
        this.player = player;
        this.maxIterations = maxIterations;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long age = this.player.askNextGuess();
        if (age != this.numberToGuess) {
            player.respond(age < this.numberToGuess);
            return false;
        }
        else
            return true;
    }

    public void loopUntilPlayerSucceed() {
        int iterations = 0;
        Long startDate = System.currentTimeMillis();
        while(!nextRound() && iterations < this.maxIterations) {
            iterations++;
        };
        Long endDate = System.currentTimeMillis();
        this.logger.log(new SimpleDateFormat("mm:ss.SSS").format(endDate - startDate));

        if (iterations < this.maxIterations) {
            this.logger.log("l'âge a été trouvé en " + iterations + " tours");
            this.logger.log("Bravo vous avez trouvé l'âge du capitaine !");
        }
        else
            this.logger.log("Le nombre max d'itérations a été atteint");
    }
}
