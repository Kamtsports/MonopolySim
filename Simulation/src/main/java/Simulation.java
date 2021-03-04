import de.kamtsports.game.Game;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Thread{

    private List<Game> games = new ArrayList<>();

    private Simulation(int amountOfGames) {
        while (games.size()<amountOfGames){
            games.add(Game.generateNewGame());
        }
    }

    public static Simulation setup(int amountOfGames){
        return new Simulation(amountOfGames);
    }

    @Override
    public void start() {

    }
}
