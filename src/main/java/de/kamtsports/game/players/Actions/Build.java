package de.kamtsports.game.players.Actions;

import de.kamtsports.game.board.Field;
import de.kamtsports.game.players.Player;

import java.util.List;

public class Build extends Action{

    private List<Field> possibleFieldsToBuildOn;



    public Build(Player player) {
        super(player);
    }

    @Override
    public void doAction() {
        updatePossibleFieldsToBuildOn();
    }

    private void updatePossibleFieldsToBuildOn() {

    }
}
