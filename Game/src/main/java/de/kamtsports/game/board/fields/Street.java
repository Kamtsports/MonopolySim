package de.kamtsports.game.board.fields;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

import java.awt.*;

public class Street extends Field {

    private int housesBuildOn;
    @CsvBindByName
    private final Color color;
    @CsvBindByName
    private final int buyPrice;
    @CsvBindAndJoinByName(column ="rent[0-5]",elementType = Integer.class)
    private int [] rents;
    @CsvBindByName
    private int housePrice;
    @CsvBindByName
    private int mortage;


    //Fields are created once and then only reused -> Defaults are set
    public Street(String name, int buyPrice, Color color) {
        super(name,Buildstatus.FORBIDDEN, Sellstatus.UNSOLD);
        this.buyPrice = buyPrice;
        this.color = color;
        Game.game.gameBoard.getColorGroups().get(color).add(this);
    }

    protected Street(String name, Color color, int buyPrice, int[] rents, int housePrice, int mortage){
        this(name,buyPrice,color);
        this.rents = rents;
        this.mortage = mortage;
        this.housePrice = housePrice;
    }




    public int getRent() {
        return rents[housesBuildOn];
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

    public int getMortageFee() {
        return mortage*Game.settings.getMortageFeePercent()/100;
    }

    public int getHousePrice() {
        return housePrice;
    }

    @Override
    public int getMortgageValue() {
        return mortage;
    }
}
