package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record PairHand(Card card1, Card card2) implements Hand {

    public PairHand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        if (!card1.isSameRankOf(card2)) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isStrongestThan(Hand hand) {
        return false;
    }

    @Override
    public int weight() {
        return 2;
    }

    public String cardRankValue() {
        return card1.rankValue();
    }
}
