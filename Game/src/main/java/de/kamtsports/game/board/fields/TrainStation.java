package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.util.ArrayList;
import java.util.List;

public class TrainStation extends Mortageable {


    private final List<TrainStation> upgradeGroup = new ArrayList<>();
    private final List<Integer> rents;


    public TrainStation(int name, int buyPrice,List<Integer> rents ,int mortgage) {
        super(name,Buildstatus.IMPOSSIBLE, Sellstatus.UNSOLD,buyPrice,mortgage);
        this.rents = rents;
    }




    public int getRents() {
        return rents.get(getAmountOwnedInGroup());
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

    public int getBuyPrice() {
        return buyPrice;
    }

    public void addToUpgradeGroup(TrainStation trainStation){
        upgradeGroup.add(trainStation);
    }

}
