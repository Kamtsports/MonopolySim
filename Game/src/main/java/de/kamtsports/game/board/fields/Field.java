package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import de.kamtsports.game.players.Player;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @Type(value = Street.class, name = "street"),
        @Type(value = TrainStation.class, name = "trainStation"),
        @Type(value = SpecialStation.class, name = "specialStation"),
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
    protected final int id;

    public Field(int id, Buildstatus buildstatus, Sellstatus sellstatus) {
        this.id = id;
        this.buildstatus = buildstatus;
        this.sellstatus = sellstatus;
    }


    @Override
    public String toString() {
        return id + getClass().getSimpleName();
    }
}
