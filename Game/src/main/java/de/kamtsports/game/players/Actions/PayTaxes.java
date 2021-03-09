package de.kamtsports.game.players.Actions;

import de.kamtsports.game.players.Player;

public class PayTaxes extends Action{

    final int amount;

    public PayTaxes(Player actor,int amount) {
        super(actor);
        this.amount = amount;
    }

    @Override
    public void doAction() {

    }
}
