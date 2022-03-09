import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Simulation;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        Simulation simulation = new Simulation(
            new HumanPlayer()
        );
        SecureRandom random = new SecureRandom();
        simulation.initialize(random.nextInt(100));
        simulation.loopUntilPlayerSucceed();
    }
}
