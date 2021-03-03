package de.kamtsports.game.players.Actions;

import de.kamtsports.game.board.Field;
import de.kamtsports.game.players.Player;


public abstract class Action {

    private Player actor;
    private Field field;

    public Action(Player actor, Field field) {
        this.actor = actor;
        this.field = field;
    }

    public Action(Player player) {
        this(player,null);
    }

    public Action(Field field) {
        this(null,field);
    }


    public abstract void doAction();
}
