package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.ActionField;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.fields.Mortgageable;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import de.kamtsports.game.objects.Die;
import de.kamtsports.game.players.Actions.Action;
import de.kamtsports.game.players.Actions.Auction;
import de.kamtsports.game.players.Actions.Buy;
import de.kamtsports.game.players.Actions.GotoJail;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {


    @Getter
    private final String name;
    @Getter
    protected Field standingOn;
    @Getter
    @Setter
    private int balance;
    @Getter
    @Setter
    private boolean inJail = false;
    private final List<Action> possibleActions = new ArrayList<>();
    private int doublesInRow;

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    public void startTurn() {
        int fieldsToMove = rollDice();
        if (inJail && haveRolledDouble()) {
            move(fieldsToMove);
            inJail = false;
        } else if (haveRolledDouble()) {
            if (doublesInRow == 3) doAction(new GotoJail(this));
            else {
                move(fieldsToMove);
                rollDice();
            }
        } else move(fieldsToMove);
    }

    private int rollDice() {
        int amountRolled = 0;
        Die.roll(Game.settings.getDieAmount());
        for (Integer integer : Die.getLastRolls()) {
            amountRolled += integer;
            if (amountRolled >= Game.game.gameBoard.getFields().size() - 1) {
                amountRolled = amountRolled - Game.game.gameBoard.getFields().size();
            }
        }
        return amountRolled;
    }

    private void move(int fieldsToMove) {
        int indexOfField = Game.game.gameBoard.getFields().indexOf(standingOn);
        stepOn(Game.game.gameBoard.getFields().get(indexOfField + fieldsToMove));
    }

    private void stepOn(Field field) {
        if (field.getClass() == ActionField.class) {
            ActionField actionField = (ActionField) field;
            actionField.doAction(this);
        }
        updatePossibleActionsUponArrival(field);
        Game.settings.getVisualSolution().displayPossibleActions(possibleActions);
    }

    private boolean haveRolledDouble() {
        boolean gamesDouble = true;
        Integer first = Die.getLastRolls().get(0);
        for (Integer other : Die.getLastRolls()) {
            if (!other.equals(first)) {
                gamesDouble = false;
                break;
            }
        }
        if (gamesDouble) doublesInRow++;
        return gamesDouble;
    }

    private void updatePossibleActionsUponArrival(Field field) {
        if (field.getSellstatus() == Sellstatus.UNSOLD) {
            possibleActions.add(new Buy(this, (Mortgageable) field));
            if (Game.settings.isRequireAuction()) {
                possibleActions.add(new Auction(field));
            }
        }
    }

    @Override
    public void loose() {
        Game.game.getPlayers().remove(this);
    }
}
