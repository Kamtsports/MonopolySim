package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class SpecialStation extends Mortgageable {


    private final List<SpecialStation> upgradeGroup = new ArrayList<>();
    private final List<Integer> rent;

    @JsonCreator
    public SpecialStation(@JsonProperty("id") int id, @JsonProperty("buyPrice") int buyPrice,@JsonProperty("rent") List<Integer> rent ,@JsonProperty("mortage") int mortgage) {
        super(id,Buildstatus.IMPOSSIBLE, Sellstatus.UNSOLD,buyPrice,mortgage);
        this.rent = rent;

    }

    private int getAmountOwnedInGroup(){
        int amount = 0;
        for (SpecialStation specialStation : upgradeGroup){
            if (specialStation != this && specialStation.owner == this.owner){
                amount++;
            }
        }
        return amount;
    }

    public int getRent() {
        return rent.get(getAmountOwnedInGroup());
    }

    public void addToUpgradeGroup(SpecialStation specialStation){
        upgradeGroup.add(specialStation);
    }


}
