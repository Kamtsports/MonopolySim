package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class SpecialStation extends Mortageable {


    private final List<Street> upgradeGroup = new ArrayList<>();


    public SpecialStation(int id, int buyPrice, int mortgage) {
        super(id,Buildstatus.IMPOSSIBLE, Sellstatus.UNSOLD,buyPrice,mortgage);

    }

    public void addToUpgradeGroup(Street street){
        upgradeGroup.add(street);
    }

}
