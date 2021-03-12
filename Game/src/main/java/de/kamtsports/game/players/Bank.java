package de.kamtsports.game.players;

import de.kamtsports.game.players.Actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Bank extends Player{

    final protected List<Action> possibleActions = new ArrayList<>();

    private int availableHouses;

    public Bank() {
        super();
    }

    @Override
    public void loose() {

    }

}
