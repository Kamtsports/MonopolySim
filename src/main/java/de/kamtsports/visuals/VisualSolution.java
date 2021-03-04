package de.kamtsports.visuals;

import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public interface VisualSolution {

    void displayPossibleActions(List<Action> possibleActions);

    void displayAction();
}
