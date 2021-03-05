package de.kamtsports.game.Settings;

import de.kamtsports.game.objects.DiceType;
import de.kamtsports.visuals.VisualSolution;

public class Settings {

    private boolean requireAuction;
    private VisualSolution visualSolution;
    private DiceType diceType;
    private int diceAmount;


    private Settings(VisualSolution visualSolution) {
        this.visualSolution = visualSolution;
    }

    public static Settings generateRules(SettingType type, VisualSolution visualSolution) {
        Settings settings = new Settings(visualSolution);
        if (type == SettingType.DEFAULT) {
            settings.requireAuction = false;
            settings.diceAmount = 2;
            settings.diceType = DiceType.D6;
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
}
