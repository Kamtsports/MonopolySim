package de.kamtsports.game.players.Actions;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.Mortgageable;
import de.kamtsports.game.board.fields.Street;
import de.kamtsports.game.players.HumanPlayer;

import java.util.ArrayList;
import java.util.List;

public class Build extends Action {

    private final List<Street> possibleFieldsToBuildOn = new ArrayList<>();


    public Build(HumanPlayer player) {
        super(player);
    }

    @Override
    public void doAction() {
        updatePossibleFieldsToBuildOn();
        Game.settings.getVisualSolution().displayFieldsThatCanBeBuildOn(possibleFieldsToBuildOn);
        Street field = Game.settings.getVisualSolution().readFieldToBuildOn();
        if (field != null) field.addHouse();
    }

    private void updatePossibleFieldsToBuildOn() {
        possibleFieldsToBuildOn.clear();
        if (Game.bank.getAvailableHouses() > 0) {
            for (Mortgageable field : actor.getOwnedFields()) {
                if (Game.settings.isAllowLazyUpgrade()){
                    if (field.getClass() == Street.class) possibleFieldsToBuildOn.add((Street) field);
                } else if (field.getAmountOwnedInGroup() == field.getUpgradegroup().size() && field.getClass() == Street.class) {
                    possibleFieldsToBuildOn.add((Street) field);
                }
            }
        }
    }
}
