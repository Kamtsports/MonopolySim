package de.kamtsports.game.board.gameBoards;

import de.kamtsports.game.board.fields.ColorGroup;
import de.kamtsports.helper.CSVHelper;
import de.kamtsports.helper.ColorHelper;

public class StandardBoard extends GameBoard {


    String pathToCSV = "C:\\dev\\IntelliJ IDEA\\MonopolySim\\Game\\src\\main\\resources\\StandardBoard.csv";

    public StandardBoard() {
        generateColorGroups();
        generateFields();
        System.out.println(getFields());
    }

    @Override
    protected void generateColorGroups() {
        String [] colors = {"purple","cyan","magenta","orange","red","yellow","darkGreen","blue"};
        for (String color : colors){
            colorGroups.put(ColorHelper.getColor(color),new ColorGroup(ColorHelper.getColor(color)));
        }
    }


    @Override
    protected void generateFields() {
        CSVHelper.generateFieldsFromFile(pathToCSV);
    }
}
