package de.kamtsports.game.objects;

public enum DieType {
    D6(6),
    D10(10),
    D12(12),
    D20(20);

    final int min;
    final int max;
    DieType(int max){
        this.min = 1;
        this.max = max;
    }

}
