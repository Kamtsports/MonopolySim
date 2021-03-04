package de.kamtsports.game.fields;

import de.kamtsports.game.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.fields.fieldStatus.Sellstatus;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Street extends Field {

    private int housesBuildOn;
    private final int buyPrice;
    private final List<Street> colorGroup = new ArrayList<>();
    private final Color color;

    //Fields are created once and then only reused -> Defaults are set
    public Street(int buyPrice, Color color) {
        super(Buildstatus.FORBIDDEN, Sellstatus.UNSOLD);
        this.buyPrice = buyPrice;
        this.color = color;
    }





    public void addToColorGroup(Street street){
        colorGroup.add(street);
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

    @Override
    public int getMortgageValue() {
        return buyPrice/2;
    }
}
