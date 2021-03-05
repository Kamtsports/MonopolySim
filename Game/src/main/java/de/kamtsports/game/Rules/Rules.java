package de.kamtsports.game.Rules;

import de.kamtsports.visuals.VisualSolution;

public class Rules {

    private boolean requireAuction;
    private VisualSolution visualSolution;
    private Ruletype type;

    public Rules() {
    }

    public static Rules generateRules(Ruletype type,VisualSolution visualSolution) {
        Rules rules;
        if (type == Ruletype.DEFAULT) {
            rules = new Rules();
            rules.visualSolution = visualSolution;
            rules.requireAuction = false;
        } else {
            rules = visualSolution.configureRules();
        }
        return rules;
    }


    public VisualSolution getVisualSolution() {
        return visualSolution;
    }

    public void setRequireAuction(boolean requireAuction) {
        this.requireAuction = requireAuction;
    }

    public boolean isRequireAuction() {
        return requireAuction;
    }
}
