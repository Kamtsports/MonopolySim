package de.kamtsports.game;

import de.kamtsports.game.Settings.SettingType;
import de.kamtsports.game.Settings.Settings;
import de.kamtsports.game.board.gameBoards.GameBoard;
import de.kamtsports.game.board.gameBoards.StandardBoard;
import de.kamtsports.game.players.Player;
import de.kamtsports.helper.ClassHelper;
import de.kamtsports.visuals.Console;
import de.kamtsports.visuals.VisualSolution;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();
    public static Settings settings;
    public static Game game = null;
    public final GameBoard gameBoard;

    private Game(Settings settings, GameBoard gameBoard) {
        Game.settings = settings;
        this.gameBoard = gameBoard;
        game = this;
    }

    public static void generateNewGame(SettingType settingType, VisualSolution visualSolution,GameBoard gameBoard) {
        if (game == null){
            new Game(Settings.generateSettings(settingType, visualSolution),gameBoard);
        }
    }

    public static void generateNewGame(String ... uiName) {
        String packageName = "de.kamtsports.visuals";
        if (uiName.length == 0){
            generateNewGame(SettingType.DEFAULT, new Console(),new StandardBoard());
        } else {
            try {
                generateNewGame(SettingType.DEFAULT,(VisualSolution) Class.forName(packageName + uiName[0]).getConstructor().newInstance(),new StandardBoard());
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                List<String> classesInPackage = ClassHelper.getListOfClassesInPackage(packageName);
                System.out.print("Uitype must be one of the following: ");
                for (String s : classesInPackage){
                    if (s.equals("VisualSolution")) continue;
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void start() {

    }
}
