package de.kamtsports.game.players.Actions;

import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.players.HumanPlayer;
import de.kamtsports.game.players.Player;


public abstract class Action {

    final protected Player actor;
    final protected Field field;


    public Action(Player actor, Field field) {
        this.actor = actor;
        this.field = field;
    }

    public Action(Player actor) {
        this(actor,null);
    }

    public Action(Field field) {
        this(null,field);
    }

    public static Action getActionFromString(String s, HumanPlayer player) {
        return switch (s) {
            case "taxes" -> new PayTaxes(player, 200);
            case "extraTaxes" -> new PayTaxes(player, 100);
            case "wage" -> new Wage(player,"Start");
            case "jail" -> new Jail(player);
            case "freePark" -> new Wage(player,"freePark");
            case "none" -> null;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    //TODO implement doAction and invocation of it
    public abstract void doAction();


}
