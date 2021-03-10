package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

public class Corner extends Field{

    @JsonCreator
    public Corner(@JsonProperty int id) {
        super(id, Buildstatus.IMPOSSIBLE, Sellstatus.CANNOT_BE_SOLD);
        System.out.println("Corner");
    }


}
