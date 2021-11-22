package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record HighCardHand(Card card) implements Hand {

    public HighCardHand {
        Objects.requireNonNull(card);
    }

    @Override
    public Hand determinateBestHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String cardRankValue() {
        return card.rankValue();
    }
}
