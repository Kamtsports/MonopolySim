package de.kamtsports.game.objects;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    DiceType type;

    public Dice(DiceType type) {
        this.type = type;
    }

    public Dice() {
        this(DiceType.D6);
    }


    public int roll(){
        return ThreadLocalRandom.current().nextInt(type.min,type.max+1);
    }
}
