package de.kamtsports.game.players.Actions;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.objects.Dice;
import de.kamtsports.game.players.HumanPlayer;

public class RollDice extends Action {

    private int doublesInRow;

    public RollDice(HumanPlayer actor, Field field) {
        super(actor, field);
    }

    @Override
    public void doAction() {
        HumanPlayer actor = (HumanPlayer) this.actor;
        int indexOfField = Game.game.gameBoard.getFields().indexOf(actor.getStandingOn());
        Dice.roll(Game.settings.getDiceAmount());

        for (Integer integer : Dice.getLastRolls()) {
                indexOfField += integer;
                if (indexOfField >= Game.game.gameBoard.getFields().size()-1) {
                    indexOfField = indexOfField - Game.game.gameBoard.getFields().size();
                }
        }

        if (haveRolledDouble()) {
            if (doublesInRow == 3) {
                actor.doAction(new Jail(actor));
            } else {
                actor.stepOn(Game.game.gameBoard.getFields().get(indexOfField));
                doAction();
            }
        } else {
            actor.stepOn(Game.game.gameBoard.getFields().get(indexOfField));
        }
    }

    private boolean haveRolledDouble() {
        boolean gamesDouble = true;
        Integer first = Dice.getLastRolls().get(0);
        for (Integer other : Dice.getLastRolls()) {
            if (!other.equals(first)) {
                gamesDouble = false;
                break;
            }
        }
        if (gamesDouble) doublesInRow++;
        return gamesDouble;
    }
}
