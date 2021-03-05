package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.fields.Field;

public class HumanPlayer extends Player {

    private int balance;



    public HumanPlayer() {
        super();
    }

    public void stepOn(Field field) {
        updatePossibleActionsUponArrival(field);
        Game.settings.getVisualSolution().displayPossibleActions(possibleActions);
    }

    public int getBalance() {
        return balance;
    }

}
