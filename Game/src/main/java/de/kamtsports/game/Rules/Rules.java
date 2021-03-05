package de.kamtsports.game.Rules;

import de.kamtsports.visuals.VisualSolution;

public class Rules {

    private boolean requireAuction;
    private VisualSolution visualSolution;
    private Ruletype type;

    public Rules(VisualSolution visualSolution) {
        this.visualSolution = visualSolution;
    }

    public static Rules generateRules(Ruletype type,VisualSolution visualSolution) {
        Rules rules;
        if (type == Ruletype.DEFAULT) {
            rules = new Rules(visualSolution);
            rules.requireAuction = false;
        } else {
            rules = visualSolution.configureRules();
        }
        rules.type = type;
        return rules;
    }




    public VisualSolution getVisualSolution() {
        return visualSolution;
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
