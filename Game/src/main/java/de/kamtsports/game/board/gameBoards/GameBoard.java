package de.kamtsports.game.board.gameBoards;

import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.fields.Street;
import de.kamtsports.helper.ColorHelper;
import de.kamtsports.helper.JSONHelper;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class  GameBoard {

    protected final HashMap<Color, List<Street>> colorGroups = new HashMap<>();
    protected final List<Field> fields;
    private final String path = "StandardBoard.json";

    public GameBoard() {
        generateColorGroups();
        fields = JSONHelper.generateFields(path);
        for (Field field : fields){
            if (field.getClass() == Street.class){
                Street street = (Street) field;
                addToColorGroup(street.getColor(),street);
            }

        }
    }


    public void addToColorGroup(Color color, Street street){
        colorGroups.get(color).add(street);
    }

    private void generateColorGroups() {
        String [] colors = {"purple","cyan","magenta","orange","red","yellow","darkGreen","blue"};
        for (String color : colors){
            colorGroups.put(ColorHelper.getColor(color),new ArrayList<>());
        }
    }


}
