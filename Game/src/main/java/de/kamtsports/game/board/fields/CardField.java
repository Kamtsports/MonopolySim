package de.kamtsports.game.board.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.CardType;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

public class CardField extends Field {

    private final CardType cardType;

    @JsonCreator
    public CardField(@JsonProperty int id, @JsonProperty CardType cardType) {
        super(id, Buildstatus.IMPOSSIBLE, Sellstatus.CANNOT_BE_SOLD);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }
}
