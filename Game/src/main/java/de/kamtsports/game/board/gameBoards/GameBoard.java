package de.kamtsports.game.board.gameBoards;

import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.fields.Street;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class  GameBoard {

    protected final HashMap<Color, List<Street>> colorGroups = new HashMap<>();
    protected List<Field> fields = new ArrayList<>();




    protected abstract void generateColorGroups();

    public void addToColorGroup(Color color, Street street){
        colorGroups.get(color).add(street);
    }

    public HashMap<Color, List<Street>> getColorGroups() {
        return colorGroups;
    }

    public List<Field> getFields() {
        return fields;
    }


}
