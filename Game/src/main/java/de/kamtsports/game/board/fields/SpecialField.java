package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class SpecialField extends Field {

    private final int buyPrice;
    private final List<Street> upgradeGroup = new ArrayList<>();


    public SpecialField(String name,Sellstatus sellstatus,int buyPrice) {
        super(name,Buildstatus.IMPOSSIBLE, sellstatus);
        this.buyPrice = sellstatus == Sellstatus.UNSOLD ? buyPrice : 0;
    }

    public void addToUpgradeGroup(Street street){
        upgradeGroup.add(street);
    }

    @Override
    public int getMortgageValue() {
        return buyPrice == 0 ? 0 : buyPrice / 2;
    }
}
