package de.kamtsports.game;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.Rules.Ruletype;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.players.Player;
import de.kamtsports.visuals.Console;
import de.kamtsports.visuals.VisualSolution;

import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {

    private final List<Player> players = new ArrayList<>();
    private final List<Field> fields;
    public final Rules rules;


    private Game(Rules rules) {
        this.rules = rules;
        fields = generateFields();
    }

    public static Game generateNewGame(Ruletype ruletype, VisualSolution visualSolution) {
        return new Game(Rules.generateRules(ruletype, visualSolution));
    }

    public static Game generateNewGame() {
        return generateNewGame(Ruletype.DEFAULT, new Console());
    }


    private List<Field> generateFields() {
        List<Field> fields = new ArrayList<>();


        return fields;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Field> getFields() {
        return fields;
    }
}
