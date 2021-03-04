package de.kamtsports.game.fields;

import de.kamtsports.game.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class SpecialField extends Field {

    private final int buyPrice;
    private final List<Street> upgradeGroup = new ArrayList<>();


    public SpecialField(Sellstatus sellstatus,int buyPrice) {
        super(Buildstatus.IMPOSSIBLE, sellstatus);
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
