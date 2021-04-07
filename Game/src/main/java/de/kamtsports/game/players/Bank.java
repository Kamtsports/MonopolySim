package de.kamtsports.game.players;

import lombok.Getter;

public class Bank extends Player{

    @Getter
    private int availableHouses;

    public Bank() {
        super();
    }

    @Override
    public void loose() {

    }

}
