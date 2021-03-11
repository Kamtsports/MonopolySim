package de.kamtsports.game.board.fields;

import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import lombok.Getter;


public abstract class Mortgageable extends Field {

    @Getter
    protected final int mortgage;
    @Getter
    protected final int buyPrice;
    @Getter
    protected boolean mortgaged;

    public Mortgageable(int name, Buildstatus buildstatus, Sellstatus sellstatus, int buyPrice, int mortgage) {
        super(name, buildstatus, sellstatus);
        this.mortgage = mortgage;
        this.buyPrice = buyPrice;
    }

    public int getMortageFee() {
        return mortgage * Game.settings.getMortageFeePercent() / 100;
    }

}

