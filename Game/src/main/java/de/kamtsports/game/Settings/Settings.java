package de.kamtsports.game.Settings;

import de.kamtsports.game.board.fields.Street;
import de.kamtsports.game.board.gameBoards.GameBoard;
import de.kamtsports.game.board.gameBoards.StandardBoard;
import de.kamtsports.game.objects.DiceType;
import de.kamtsports.visuals.VisualSolution;

public class Settings {

    private boolean requireAuction;
    private VisualSolution visualSolution;
    private DiceType diceType;
    private int diceAmount;
    private int mortageFeePercent;

    private Settings(VisualSolution visualSolution) {
        this.visualSolution = visualSolution;
    }

    public static Settings generateSettings(SettingType type, VisualSolution visualSolution) {
        Settings settings = new Settings(visualSolution);
        if (type == SettingType.DEFAULT) {
            settings.requireAuction = false;
            settings.diceAmount = 2;
            settings.diceType = DiceType.D6;
            settings.mortageFeePercent = 10;
        }
        return settings;
    }


    public DiceType getDiceType() {
        return diceType;
    }

    public int getDiceAmount() {
        return diceAmount;
    }

    public VisualSolution getVisualSolution() {
        return visualSolution;
    }

    public void setDiceType(DiceType diceType) {
        this.diceType = diceType;
    }

    public void setDiceAmount(int diceAmount) {
        this.diceAmount = diceAmount;
    }

    public void setVisualSolution(VisualSolution visualSolution) {
        this.visualSolution = visualSolution;
    }

    public void setRequireAuction(boolean requireAuction) {
        this.requireAuction = requireAuction;
    }

    public boolean isRequireAuction() {
        return requireAuction;
    }

    public int getMortageFeePercent() {
        return mortageFeePercent;
    }
}
