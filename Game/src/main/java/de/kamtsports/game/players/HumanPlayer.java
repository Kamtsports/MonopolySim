package de.kamtsports.game.players;

import de.kamtsports.game.Game;
import de.kamtsports.game.objects.Dice;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {

    private int balance;
    private List<Dice> dices = new ArrayList<>();


    public HumanPlayer(Game game) {
        super(game);
        dices.add(new Dice());
        dices.add(new Dice());
    }

    public void rollDice(){
        int diceRoll = 0;
        for (Dice dice : dices){
            diceRoll += dice.roll();
        }
        int indexOfField = getGame().getFields().indexOf(getStandingOn());
        for (int i = 0; i < diceRoll; i++) {
            indexOfField++;
            if (indexOfField==getGame().getFields().size()){
                indexOfField = 0;
            }
        }
        stepOn(getGame().getFields().get(indexOfField));
    }
}
