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

    @Override
    public int weight() {
        return 1;
    }

    @Override
    public boolean isStrongestThan(Hand hand) {
        return weight() > hand.weight() ||
                (weight() == hand.weight() && card.isStrongerThan(((HighCardHand) hand).card));
    }

    public String cardRankValue() {
        return card.rankValue();
    }
}
