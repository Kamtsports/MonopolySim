package de.kamtsports.simulation;

import de.kamtsports.game.Main;

public class Simulation extends Thread {

    //TODO write Simulation Code
    private Simulation(int amountOfGames) {
        for (int i = 0; i < amountOfGames; i++) {
            Main.main(null);
        }
    }

    public static Simulation setup(int amountOfGames) {
        return new Simulation(amountOfGames);
    }

}
