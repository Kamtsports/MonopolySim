package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.objects.Dice;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {

    private int balance;
    private List<Dice> dices = new ArrayList<>();


    public HumanPlayer(Game game) {
        super(game);
        dices.add(new Dice());
        dices.add(new Dice());
    }

    public void stepOn(Field field) {
        updatePossibleActionsUponArrival(field);
        game.rules.getVisualSolution().displayPossibleActions(possibleActions);
    }

    public int getBalance() {
        return balance;
    }

    public List<Dice> getDices() {
        return dices;
    }
}
