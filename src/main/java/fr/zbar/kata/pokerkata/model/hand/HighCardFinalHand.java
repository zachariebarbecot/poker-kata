package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record HighCardFinalHand(Card card) implements FinalHand {

    public HighCardFinalHand {
        Objects.requireNonNull(card);
    }

    @Override
    public boolean isStrongerThan(FinalHand finalHand) {
        return weight() > finalHand.weight() ||
                (weight() == finalHand.weight() && card.isStrongerThan(((HighCardFinalHand) finalHand).card));
    }

    @Override
    public int weight() {
        return 1;
    }

    public String cardRankValue() {
        return card.rankValue();
    }
}
