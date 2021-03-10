package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import de.kamtsports.game.Game;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonSubTypes.*;

@JsonSubTypes({
        @Type(value = Street.class, name = "street"),
        @Type(value = TrainStation.class, name = "trainStation"),
        @Type(value = SpecialStation.class, name = "specialStation")
})

public abstract class Mortgageable extends Field {

    @Getter
    protected final int mortgage;
    @Getter
    protected final int buyPrice;

    public Mortgageable(int name, Buildstatus buildstatus, Sellstatus sellstatus, int buyPrice, int mortgage) {
        super(name, buildstatus, sellstatus);
        this.mortgage = mortgage;
        this.buyPrice = buyPrice;
    }

    public int getMortageFee() {
        return mortgage * Game.settings.getMortageFeePercent() / 100;
    }

}

