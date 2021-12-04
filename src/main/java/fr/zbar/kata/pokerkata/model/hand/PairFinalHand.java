package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record PairFinalHand(Card card1, Card card2) implements FinalHand {

    public PairFinalHand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        if (!card1.isSameRankOf(card2)) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isStrongerThan(FinalHand finalHand) {
        return weight() > finalHand.weight() ||
                (weight() == finalHand.weight() && card1.isStrongerThan(((PairFinalHand) finalHand).card1));
    }

    @Override
    public int weight() {
        return 2;
    }

    public String cardRankValue() {
        return card1.rankValue();
    }
}
