package de.kamtsports.visuals;

import de.kamtsports.game.players.Actions.Action;

import java.util.List;

public class Console implements VisualSolution{




    @Override
    public void displayPossibleActions(List<Action> possibleActions) {
        for (Action a : possibleActions){
            System.out.println(a);
        }
    }

    @Override
    public void displayAction(Action action) {
        System.out.println(action);
    }
}
