package de.kamtsports.game.players.Actions;

import de.kamtsports.game.Game;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.players.Player;


public abstract class Action {

    protected Player actor;
    protected Field field;
    protected Game game;

    public Action(Player actor, Field field, Game game) {
        this.actor = actor;
        this.field = field;
    }

    public Action(Player actor, Field field) {
       this(actor,field,actor.getGame());
    }

    public Action(Player actor) {
        this(actor,null,actor.getGame());
    }

    public Action(Field field) {
        this(null,field,field.getGame());
    }


    public abstract void doAction();


}
