package de.kamtsports.game;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.players.Player;
import de.kamtsports.visuals.None;
import de.kamtsports.visuals.VisualSolution;
import de.kamtsports.game.Rules.Rulesets;

import java.util.ArrayList;
import java.util.List;

public class Game extends Thread{

    private final List<Player> players = new ArrayList<>();
    private final List<Field> fields;
    public VisualSolution visualSolution;
    public final Rules rules;


    private Game(VisualSolution visualSolution, Rulesets ruleset) {
        rules = Rules.generateRules(ruleset);
        fields = generateFields();
    }
    private Game() {
        this(new None(),Rulesets.DEFAULT);
    }

    public static Game generateNewGame(){
        return new Game();
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
