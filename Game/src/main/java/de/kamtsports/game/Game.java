package de.kamtsports.game;

import de.kamtsports.game.Settings.SettingType;
import de.kamtsports.game.Settings.Settings;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.players.Player;
import de.kamtsports.helper.ClassHelper;
import de.kamtsports.visuals.Console;
import de.kamtsports.visuals.VisualSolution;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();
    private final List<Field> fields;
    public static Settings settings;
    public static Game game = null;

    private Game(Settings settings) {
        Game.settings = settings;
        fields = generateFields();
        game = this;
    }

    public static void generateNewGame(SettingType settingType, VisualSolution visualSolution) {
        if (game == null){
            new Game(Settings.generateRules(settingType, visualSolution));
        }
    }

    public static void generateNewGame(String ... uiName) {
        String packageName = "de.kamtsports.visual";
        if (uiName.length == 0){
            generateNewGame(SettingType.DEFAULT, new Console());
        } else {
            try {
                generateNewGame(SettingType.DEFAULT,(VisualSolution) Class.forName(packageName + uiName[0]).getConstructor().newInstance());
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                //TODO filter Interface
                System.out.println("Uitype must be one of the following: "  + ClassHelper.getListOfClassesInPackage(packageName));
            }
        }
    }




    private List<Field> generateFields() {
        List<Field> fields = new ArrayList<>();

        //TODO field generation
        return fields;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void start() {

    }
}
