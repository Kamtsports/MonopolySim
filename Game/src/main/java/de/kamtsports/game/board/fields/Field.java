package de.kamtsports.game.board.fields;

import de.kamtsports.game.players.Player;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;


public abstract class Field {


    protected Buildstatus buildstatus;
    protected Sellstatus sellstatus;
    protected boolean mortgaged;
    protected Player owner;
    protected String name;


    public Field(String name, Buildstatus buildstatus, Sellstatus sellstatus) {
        this.name = name;
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

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
