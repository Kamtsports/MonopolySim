package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.kamtsports.game.players.Player;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonSubTypes.*;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @Type(value = Mortgageable.class, name = "street"),
        @Type(value = Mortgageable.class, name = "trainStation"),
        @Type(value = Mortgageable.class, name = "specialStation"),
        @Type(value = ActionField.class, name = "action"),
        @Type(value = CardField.class, name = "event"),
        @Type(value = CardField.class, name = "community")
})
@Getter
public abstract class Field {


    @Setter
    protected Buildstatus buildstatus;
    @Setter
    protected Sellstatus sellstatus;
    @Setter
    protected Player owner;
    protected boolean mortgaged;
    protected final int id;

    public Field(int id, Buildstatus buildstatus, Sellstatus sellstatus) {
        System.out.println("field");
        this.id = id;
        this.buildstatus = buildstatus;
        this.sellstatus = sellstatus;
    }

}
