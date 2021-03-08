package de.kamtsports.game.board.fields;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorGroup {

    private final List<Street> streets = new ArrayList<>();
    private final Color color;


    public ColorGroup(Color color) {
        this.color = color;
    }


    public void add(Street street){
        streets.add(street);
    }


    public List<Street> getStreets() {
        return streets;
    }

    public Color getColor() {
        return color;
    }
}
