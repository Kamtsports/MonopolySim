package de.kamtsports.game.players.Actions;

import de.kamtsports.game.players.HumanPlayer;

public class PayTaxes extends Action{

    final int amount;

    public PayTaxes(HumanPlayer actor, int amount) {
        super(actor);
        this.amount = amount;
    }


    //TODO Implement ReaL Loose Conditions
    @Override
    public void doAction() {
        actor.setBalance(actor.getBalance()-amount);
        if (actor.getBalance()<0){
            actor.loose();
        }
    }
}
