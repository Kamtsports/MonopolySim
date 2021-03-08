package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class TrainStation extends Field {

    private final int buyPrice;
    private final List<Street> upgradeGroup = new ArrayList<>();

    public TrainStation(String name, int buyPrice) {
        super(name,Buildstatus.IMPOSSIBLE, Sellstatus.UNSOLD);
        this.buyPrice = buyPrice;
    }







    public int getBuyPrice() {
        return buyPrice;
    }

    public void addToUpgradeGroup(Street street){
        upgradeGroup.add(street);
    }

    @Override
    public int getMortgageValue() {
        return buyPrice/2;
    }
}
