package de.kamtsports.game.board.gameBoards;

import de.kamtsports.game.board.fields.ColorGroup;
import de.kamtsports.game.board.fields.Field;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class  GameBoard {

    protected final HashMap<Color, ColorGroup> colorGroups = new HashMap<>();
    protected final List<Field> fields = new ArrayList<>();




    protected abstract void generateFields();

    protected abstract void generateColorGroups();


    public HashMap<Color, ColorGroup> getColorGroups() {
        return colorGroups;
    }

    public List<Field> getFields() {
        return fields;
    }
}
