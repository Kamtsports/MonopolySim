package de.kamtsports.game.players.Actions;

import de.kamtsports.game.fields.Field;
import de.kamtsports.game.objects.Dice;
import de.kamtsports.game.players.HumanPlayer;

public class RollDice extends Action{


    public RollDice(HumanPlayer actor, Field field) {
        super(actor, field);
    }

    @Override
    public void doAction() {
            int diceRoll = 0;
            HumanPlayer actor = (HumanPlayer) this.actor;
            for (Dice dice : actor.getDices()){
                diceRoll += dice.roll();
            }
            int indexOfField = game.getFields().indexOf(actor.getStandingOn());
            for (int i = 0; i < diceRoll; i++) {
                indexOfField++;
                if (indexOfField==game.getFields().size()){
                    indexOfField = 0;
                }
            }
            actor.stepOn(game.getFields().get(indexOfField));
    }
}
