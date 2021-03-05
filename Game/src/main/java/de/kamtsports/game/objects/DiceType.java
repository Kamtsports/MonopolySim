package de.kamtsports.game.objects;

public enum DiceType {
    D6(6),
    D10(10),
    D12(12),
    D20(20);

    final int min;
    final int max;
    DiceType(int max){
        this.min = 1;
        this.max = max;
    }

}
