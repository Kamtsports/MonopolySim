package de.kamtsports.visuals;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.Rules.Ruletype;
import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public class None implements VisualSolution {



    @Override
    public Rules configureRules() {
        return Rules.generateRules(Ruletype.DEFAULT, this);
    }

    @Override
    public void displayPossibleActions(List<Action> possibleActions) {

    }

    @Override
    public void displayAction(Action action) {

    }
}
