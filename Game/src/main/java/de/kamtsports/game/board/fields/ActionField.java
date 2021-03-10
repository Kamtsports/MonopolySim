package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import de.kamtsports.game.players.Actions.Action;
import de.kamtsports.game.players.HumanPlayer;

public class ActionField extends Field{

    private final String action;

    @JsonCreator
    public ActionField(@JsonProperty int id,@JsonProperty String action) {
        super(id, Buildstatus.IMPOSSIBLE, Sellstatus.CANNOT_BE_SOLD);
        this.action = action;
    }


    public void doAction(HumanPlayer humanPlayer) {
        Action.getActionFromString(action,humanPlayer).doAction();
    }
}
