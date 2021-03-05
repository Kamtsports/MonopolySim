package de.kamtsports.game.objects;

public enum DiceType {
    D6(1,6),
    D10(1,10),
    D12(1,12),
    D20(1,20);

    int min,max;
    DiceType(int min, int max){
        this.min = min;
        this.max = max;
    }

}
