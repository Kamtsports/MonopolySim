package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import de.kamtsports.game.players.Actions.Action;
import de.kamtsports.game.players.Actions.Auction;
import de.kamtsports.game.players.Actions.Buy;

import java.util.ArrayList;
import java.util.List;


public abstract class Player {

    protected Field standingOn;
    final protected List<Action> possibleActions = new ArrayList<>();

    public Player() {
    }



    protected void updatePossibleActionsUponArrival(Field field) {
        if (field.getSellstatus() == Sellstatus.UNSOLD){
            possibleActions.add(new Buy(this,field));
            if (Game.settings.isRequireAuction()){
                possibleActions.add(new Auction(field));
            }
        }
    }





    public void doAction(Action action) {
        action.doAction();
        Game.settings.getVisualSolution().displayAction(action);
    }

    public Field getStandingOn() {
        return standingOn;
    }

}
