package de.kamtsports.helper;

import java.awt.*;

public abstract class ColorHelper {


    private static final Color purple = new Color(128, 0, 128);
    private static final Color orange = new Color(255, 140, 0);
    private static final Color darkGreen = new Color(0, 100, 0);


    public static Color getColor(String color) {
        Color color1;
        switch (color) {
            case "purple" -> color1 = purple;
            case "cyan" -> color1 = Color.cyan;
            case "magenta" -> color1 = Color.magenta;
            case "orange" -> color1 = orange;
            case "red" -> color1 = Color.red;
            case "yellow" -> color1 = Color.yellow;
            case "darkGreen" -> color1 = darkGreen;
            case "blue" -> color1 = Color.blue;
            default -> color1 = null;
        }
        return color1;
    }

}
