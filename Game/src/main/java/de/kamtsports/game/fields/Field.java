package de.kamtsports.game.fields;

import de.kamtsports.game.players.Player;
import de.kamtsports.game.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.fields.fieldStatus.Sellstatus;


public abstract class Field {


    private Buildstatus buildstatus;
    private Sellstatus sellstatus;
    private boolean mortgaged;
    private Player owner;


    public Field(Buildstatus buildstatus, Sellstatus sellstatus) {
        this.buildstatus = buildstatus;
        this.sellstatus = sellstatus;
    }




    public boolean isMortgaged() {
        return mortgaged;
    }

    public abstract int getMortgageValue();

    public Buildstatus getBuildstatus() {
        return buildstatus;
    }

    public void setBuildstatus(Buildstatus buildstatus) {
        this.buildstatus = buildstatus;
    }

    public Sellstatus getSellstatus() {
        return sellstatus;
    }

    public void setSellstatus(Sellstatus sellstatus) {
        this.sellstatus = sellstatus;
    }

    public Player getOwner() {
        return owner;
    }
}
