package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record HighCardHand(Card card) implements Hand {

    public HighCardHand {
        Objects.requireNonNull(card);
    }

    @Override
    public boolean isStrongestThan(Hand hand) {
        return weight() > hand.weight() ||
                (weight() == hand.weight() && card.isStrongerThan(((HighCardHand) hand).card));
    }

    @Override
    public int weight() {
        return 1;
    }

    public String cardRankValue() {
        return card.rankValue();
    }
}
