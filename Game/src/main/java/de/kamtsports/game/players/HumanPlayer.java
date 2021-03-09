package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.ActionField;
import de.kamtsports.game.board.fields.Field;

public class HumanPlayer extends Player {

    private int balance;



    public HumanPlayer() {
        super();
    }

    public void stepOn(Field field) {
        if (field.getClass() == ActionField.class){
            ActionField actionField = (ActionField) field;
            actionField.doAction(this);
        }
        updatePossibleActionsUponArrival(field);
        Game.settings.getVisualSolution().displayPossibleActions(possibleActions);
    }

    public int getBalance() {
        return balance;
    }

}
