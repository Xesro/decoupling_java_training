import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Simulation;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        Simulation simulation;
        long age;

        if ("-interactive".equals(args[0])) {
            simulation = new Simulation(
                new HumanPlayer(),
                Long.MAX_VALUE
            );
            SecureRandom random = new SecureRandom();
            age = random.nextInt(100);
        }
        else if("-auto".equals(args[0]) && args[1] != null) {
            simulation = new Simulation(
                new ComputerPlayer(),
                Long.MAX_VALUE
            );

            age = Integer.parseInt(args[2]);
        }
        else {
            System.out.println("usage : -interactive or -auto age");
            return;
        }

        simulation.initialize(age);
        simulation.loopUntilPlayerSucceed();
    }
}
