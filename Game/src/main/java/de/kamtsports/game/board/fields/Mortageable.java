package de.kamtsports.game.board.fields;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

public abstract class Mortageable extends Field {

    protected final int mortgage;
    protected final int buyPrice;

    public Mortageable(int name, Buildstatus buildstatus, Sellstatus sellstatus, int buyPrice , int mortgage) {
        super(name, buildstatus, sellstatus);
        this.mortgage = mortgage;
        this.buyPrice = buyPrice;
    }


    public int getMortageFee() {
        return mortgage* Game.settings.getMortageFeePercent()/100;
    }


    public int getMortgageValue() {
        return mortgage;
    }
}

