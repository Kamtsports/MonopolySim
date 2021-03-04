package de.kamtsports.game.Rules;

public class Rules {

    private boolean requireAuction;


    private Rules() {
    }

    public static Rules generateRules(Rulesets ruleset) {
        Rules rules = new Rules();
        switch (ruleset){
            case DEFAULT -> {
                rules.requireAuction = false;
            }
            case CUSTOM -> {
            }
        }
        return rules;
    }



    public boolean isRequireAuction() {
        return requireAuction;
    }
}
