package de.kamtsports.game.board.fields;

import de.kamtsports.game.players.Player;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;


public abstract class Field {


    protected Buildstatus buildstatus;
    protected Sellstatus sellstatus;
    protected boolean mortgaged;
    protected Player owner;
    protected int id;


    public Field(int id, Buildstatus buildstatus, Sellstatus sellstatus) {
        this.id = id;
        this.buildstatus = buildstatus;
        this.sellstatus = sellstatus;
    }




    public boolean isMortgaged() {
        return mortgaged;
    }

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
