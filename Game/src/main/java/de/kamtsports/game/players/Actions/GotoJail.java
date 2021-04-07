package de.kamtsports.game.players.Actions;

import de.kamtsports.game.players.HumanPlayer;

public class GotoJail extends Action{


    public GotoJail(HumanPlayer actor) {
        super(actor);
    }

    @Override
    public void doAction() {
        actor.setInJail(true);
    }
}
