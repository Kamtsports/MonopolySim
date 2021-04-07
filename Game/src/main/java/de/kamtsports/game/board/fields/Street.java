package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import lombok.Getter;

import java.awt.*;
import java.util.List;

public class Street extends Mortgageable {


    @Getter
    private final Color color;
    @Getter
    private final int housePrice;
    private int housesBuildOn;
    private final List<Integer> rent;

    @JsonCreator
    public Street(@JsonProperty("id") int id,@JsonProperty("color") Color color,@JsonProperty("buyPrice") int buyPrice,@JsonProperty("rent") List<Integer> rent,@JsonProperty("housePrice") int housePrice,@JsonProperty("mortage") int mortage) {
        super(id, Buildstatus.FORBIDDEN, Sellstatus.UNSOLD, buyPrice, mortage);
        this.color = color;
        this.rent = rent;
        this.housePrice = housePrice;
    }

    public int getRent() {
        return rent.get(housesBuildOn);
    }

    public void addHouse() {
        housesBuildOn++;
    }

    public void removeHouse() {
        housesBuildOn--;
    }


    @Override
    public List<Mortgageable> getUpgradegroup() {
        return Game.game.gameBoard.getColorGroups().get(color);
    }
}

