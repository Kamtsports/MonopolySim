package de.kamtsports.visuals;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.Street;
import de.kamtsports.game.players.Actions.Action;

import java.util.List;
import java.util.Scanner;

public class Console implements VisualSolution{

    final Scanner scanner = new Scanner(System.in);

    @Override
    public void configureRules() {
        boolean valid = false;
        do {
            try {
                System.out.println("Should auctions be required?");
                Game.settings.setRequireAuction(Boolean.parseBoolean(scanner.next()));
                valid = true;
            } catch (Exception ignored){}
        }while (!valid);
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
