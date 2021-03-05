package de.kamtsports.visuals;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public interface VisualSolution {


    Rules configureRules();

    void displayPossibleActions(List<Action> possibleActions);

    void displayAction(Action action);
}
