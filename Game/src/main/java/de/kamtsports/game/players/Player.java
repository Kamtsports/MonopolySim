package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.players.Actions.Action;


public abstract class Player {

    public Player() {
    }

    public void doAction(Action action) {
        action.doAction();
        Game.settings.getVisualSolution().displayAction(action);
    }

    public abstract void loose();
}
