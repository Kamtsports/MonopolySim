package de.kamtsports.game;

import de.kamtsports.game.Settings.SettingType;
import de.kamtsports.game.Settings.Settings;
import de.kamtsports.game.board.gameBoards.GameBoard;
import de.kamtsports.game.players.Bank;
import de.kamtsports.game.players.HumanPlayer;
import de.kamtsports.helper.ClassHelper;
import de.kamtsports.visuals.Console;
import de.kamtsports.visuals.VisualSolution;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    @Getter
    private final List<HumanPlayer> players = new ArrayList<>();
    public static Settings settings;
    public static Game game = null;
    public final GameBoard gameBoard;
    public static Bank bank;

    private Game(Settings settings, GameBoard gameBoard) {
        Game.settings = settings;
        this.gameBoard = gameBoard;
        game = this;
    }

    public static void generateNewGame(SettingType settingType, VisualSolution visualSolution, GameBoard gameBoard) {
        if (game == null) {
            new Game(Settings.generateSettings(settingType, visualSolution), gameBoard);
            List<String> names = visualSolution.readPlayerNames();
            generatePlayers(names);
        }
    }

    public static void generateNewGame(String... uiName) {
        String packageName = "de.kamtsports.visuals";
        if (uiName.length == 0) {
            generateNewGame(SettingType.DEFAULT, new Console(), new GameBoard());
        } else {
            try {
                generateNewGame(SettingType.DEFAULT, (VisualSolution) Class.forName(packageName + "." + uiName[0]).getConstructor().newInstance(), new GameBoard());
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                List<String> classesInPackage = ClassHelper.getListOfClassesInPackage(packageName);
                System.out.print("Uitype must be one of the following: ");
                for (String s : classesInPackage) {
                    if (s.equals("VisualSolution")) continue;
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }

    private static void generatePlayers(List<String> players) {
        bank = new Bank();
        for (int i = 0; i < players.size() ; i++) {
            game.players.add(new HumanPlayer("player" + i));
        }
    }

    public void start() {
        players.get(0).startTurn();
    }
}
