package de.kamtsports.game.players.Actions;

import de.kamtsports.game.players.HumanPlayer;
import lombok.Getter;

public class Wage extends Action{

    @Getter
    private final int amount;

    public Wage(HumanPlayer actor, String type) {
        super(actor);
        switch (type){
            case "Start" -> amount = 200;
            case "freePark" -> amount = 10;
            default -> amount =0;
        }
    }

    @Override
    public void doAction() {

    }
}
