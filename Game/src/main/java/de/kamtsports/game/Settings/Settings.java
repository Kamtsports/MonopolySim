package de.kamtsports.game.Settings;

import de.kamtsports.game.objects.DieType;
import de.kamtsports.visuals.VisualSolution;
import lombok.Getter;
import lombok.Setter;

public class Settings {

    @Getter
    @Setter
    private boolean requireAuction;
    @Setter
    @Getter
    private VisualSolution visualSolution;
    @Getter
    @Setter
    private DieType dieType;
    @Setter
    @Getter
    private int dieAmount;
    @Getter
    private int mortageFeePercent;
    @Getter
    @Setter
    private boolean allowLazyUpgrade;

    private Settings(VisualSolution visualSolution) {
        this.visualSolution = visualSolution;
    }

    public static Settings generateSettings(SettingType type, VisualSolution visualSolution) {
        Settings settings = new Settings(visualSolution);
        if (type == SettingType.DEFAULT) {
            settings.requireAuction = false;
            settings.dieAmount = 2;
            settings.dieType = DieType.D6;
            settings.mortageFeePercent = 10;
            settings.allowLazyUpgrade = false;
        }
        return settings;
    }


}
