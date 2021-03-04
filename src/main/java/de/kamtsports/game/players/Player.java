package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.fields.fieldStatus.Sellstatus;
import de.kamtsports.game.players.Actions.Action;
import de.kamtsports.game.players.Actions.Auction;
import de.kamtsports.game.players.Actions.Buy;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private Field standingOn;
    private final Game game;
    final private List<Action> possibleActions = new ArrayList<>();

    public Player(Game game) {
        this.game = game;
    }

    public void stepOn(Field field) {
        updatePossibleActionsUponArrival(field);
        game.visualSolution.displayPossibleActions(possibleActions);
    }

    private void updatePossibleActionsUponArrival(Field field) {
        if (field.getSellstatus() == Sellstatus.UNSOLD){
            possibleActions.add(new Buy(this,field));
            if (game.rules.RequireAuction){
                possibleActions.add(new Auction(field));
            }
        }
    }

    private void doAction(Action action) {
        action.doAction();
        game.visualSolution.displayAction();
    }

}
