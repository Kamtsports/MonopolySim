package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import de.kamtsports.helper.ColorHelper;

import java.awt.*;
import java.util.List;

public class Street extends Mortageable {

    private int housesBuildOn;
    private final Color color;
    private final List<Integer> rents;
    private final int housePrice;


    public Street(int id, String color, int buyPrice, List<Integer> rents, int housePrice, int mortage) {
        super(id, Buildstatus.FORBIDDEN, Sellstatus.UNSOLD, buyPrice, mortage);
        this.color = ColorHelper.getColor(color);
        this.rents = rents;
        this.housePrice = housePrice;
    }

    public int getRent() {
        return rents.get(housesBuildOn);
    }

    public void addHouse() {
        housesBuildOn++;
    }

    public void removeHouse() {
        housesBuildOn--;
    }

    public int getHousesBuildOn() {
        return housesBuildOn;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public Color getColor() {
        return color;
    }

    public int getHousePrice() {
        return housePrice;
    }
}

