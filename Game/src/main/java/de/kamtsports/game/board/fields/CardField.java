package de.kamtsports.game.board.fields;

import de.kamtsports.game.board.fields.fieldStatus.Buildstatus;
import de.kamtsports.game.board.fields.fieldStatus.CardType;
import de.kamtsports.game.board.fields.fieldStatus.Sellstatus;

public class CardField extends Field {

    private final CardType cardType;

    public CardField(int id, CardType cardType) {
        super(id, Buildstatus.IMPOSSIBLE, Sellstatus.CANNOT_BE_SOLD);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }
}
