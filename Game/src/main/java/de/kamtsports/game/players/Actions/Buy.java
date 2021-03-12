package de.kamtsports.game.players.Actions;

import de.kamtsports.game.board.fields.Mortgageable;
import de.kamtsports.game.players.HumanPlayer;

public class Buy extends Action {

    public Buy(HumanPlayer actor, Mortgageable field) {
        super(actor, field);
    }

    @Override
    public void doAction() {
        Mortgageable field = (Mortgageable) super.field;
        if (actor.getBalance() > field.getBuyPrice()) {
            field.setOwner(actor);
            actor.setBalance(actor.getBalance() - field.getBuyPrice());
        }
    }
}
