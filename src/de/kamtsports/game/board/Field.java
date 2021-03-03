package de.kamtsports.game.board;

import de.kamtsports.game.board.fieldActions.behaviors.Buildstatus;
import de.kamtsports.game.board.fieldActions.behaviors.Sellstatus;
import de.kamtsports.game.players.Player;


public abstract class Field {

    private int housesBuildOn;
    private Buildstatus buildstatus;
    private Sellstatus sellstatus;
    private boolean mortgaged;
    private Player owner;





    public void addHouse() {
        housesBuildOn++;
    }

    public void removeHouse() {
        housesBuildOn--;
    }

    public void mortgage() {
        this.mortgaged = true;
    }

    public void unmortgage() {
        this.mortgaged = false;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public int getHousesBuildOn() {
        return housesBuildOn;
    }

    public Buildstatus getBuildstatus() {
        return buildstatus;
    }

    public Sellstatus getSellstatus() {
        return sellstatus;
    }

    public Player getOwner() {
        return owner;
    }
}
