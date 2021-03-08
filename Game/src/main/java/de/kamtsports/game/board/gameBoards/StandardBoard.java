package de.kamtsports.game.board.gameBoards;

import de.kamtsports.game.board.fields.ColorGroup;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.helper.ColorHelper;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class StandardBoard extends GameBoard {




    public StandardBoard() {
        amountOfFields = 40;
        generateColorGroups();
        generateFields();

    }

    @Override
    protected void generateColorGroups() {
        colorGroups.put(ColorHelper.purple, new ColorGroup(ColorHelper.purple));
        colorGroups.put(Color.cyan, new ColorGroup(Color.cyan));
        colorGroups.put(Color.magenta, new ColorGroup(Color.magenta));
        colorGroups.put(ColorHelper.orange, new ColorGroup(ColorHelper.orange));
        colorGroups.put(Color.red, new ColorGroup(Color.red));
        colorGroups.put(Color.yellow, new ColorGroup(Color.yellow));
        colorGroups.put(ColorHelper.darkGreen, new ColorGroup(ColorHelper.darkGreen));
        colorGroups.put(Color.blue, new ColorGroup(Color.blue));
    }


    @Override
    protected void generateFields() {

    }


    public HashMap<Color, ColorGroup> getColorGroups() {
        return colorGroups;
    }

    public List<Field> getFields() {
        return fields;
    }
}
