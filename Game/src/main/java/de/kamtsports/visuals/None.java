package de.kamtsports.visuals;

import de.kamtsports.game.board.fields.Street;
import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public class None implements VisualSolution {



    @Override
    public void configureRules() {
    }

    @Override
    public void displayPossibleActions(List<Action> possibleActions) {

    }

    @Override
    public void displayAction(Action action) {

    }

    @Override
    public void displayFieldsThatCanBeBuildOn(List<Street> possibleFieldsToBuildOn) {

    }

    @Override
    public List<String> readPlayerNames() {
        return null;
    }

    @Override
    public Street readFieldToBuildOn() {
        return null;
    }
}
