package de.kamtsports.game;

import de.kamtsports.game.Rules.Rules;
import de.kamtsports.game.fields.Field;
import de.kamtsports.game.players.Player;
import de.kamtsports.visuals.None;
import de.kamtsports.visuals.VisualSolution;

import java.util.ArrayList;
import java.util.List;

public class Game {

    final List<Player> players = new ArrayList<>();
    final List<Field> fields;
    public VisualSolution visualSolution;
    public final Rules rules;


    public Game(VisualSolution visualSolution) {
        rules = new Rules();
        fields = generateFields();
    }
    public Game() {
        this(new None());
    }

    public static Game startNewGame(){
        return new Game();
    }




    private List<Field> generateFields() {
        List<Field> fields = new ArrayList<>();


        return fields;
    }



}
