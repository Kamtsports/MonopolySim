package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class TrainStation extends Mortgageable {


    private final List<TrainStation> upgradeGroup = new ArrayList<>();
    private final List<Integer> rent;

    @JsonCreator
    public TrainStation(@JsonProperty("id") int id,@JsonProperty("buyPrice") int buyPrice,@JsonProperty("rent") List<Integer> rent ,@JsonProperty("mortage") int mortgage) {
        super(id,Buildstatus.IMPOSSIBLE, Sellstatus.UNSOLD,buyPrice,mortgage);
        this.rent = rent;
        upgradeGroup.add(this);
    }





    private int getAmountOwnedInGroup(){
        int amount = 0;
        for (TrainStation trainStation : upgradeGroup){
            if (trainStation != this && trainStation.owner == this.owner){
                amount++;
            }
        }
        return amount;
    }

    public int getRent() {
        return rent.get(getAmountOwnedInGroup());
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void addToUpgradeGroup(TrainStation trainStation){
        upgradeGroup.add(trainStation);
    }

}
