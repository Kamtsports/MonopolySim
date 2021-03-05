package de.kamtsports.visuals;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.players.Actions.Action;

import java.util.List;
import java.util.Scanner;

public class Console implements VisualSolution{

    Scanner scanner = new Scanner(System.in);

    @Override
    public Rules configureRules() {
        Rules rules = new Rules(this);
        boolean valid = false;
        do {
            try {
                System.out.println("Should auctions be required?");
                rules.setRequireAuction(Boolean.parseBoolean(scanner.next()));
                valid = true;
            } catch (Exception ignored){}
        }while (!valid);

        return rules;
    }

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
