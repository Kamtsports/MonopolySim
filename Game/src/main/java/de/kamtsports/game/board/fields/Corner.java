package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

public class Corner extends Field{
    public Corner(int name) {
        super(name, Buildstatus.IMPOSSIBLE, Sellstatus.CANNOT_BE_SOLD);
    }
}
