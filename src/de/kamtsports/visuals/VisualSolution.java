package de.kamtsports.visuals;

import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public abstract class VisualSolution {

    public abstract void displayPossibleActions(List<Action> possibleActions);

    public abstract void displayAction();
}
