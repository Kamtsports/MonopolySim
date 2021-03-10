package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.ActionField;
import de.kamtsports.game.board.fields.Field;
import lombok.Getter;

public class HumanPlayer extends Player {

    @Getter
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

}
