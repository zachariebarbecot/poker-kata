package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public record StartingHand(Card card1, Card card2, Card card3, Card card4, Card card5) implements Hand {

    public StartingHand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        Objects.requireNonNull(card3);
        Objects.requireNonNull(card4);
        Objects.requireNonNull(card5);
    }

    @Override
    public Hand determinateBestHand() {
        return Stream.of(card1, card2, card3, card4, card5)
                .max(Comparator.comparing(Card::rank))
                .map(HighCardHand::new)
                .orElseThrow();
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public boolean isStrongestThan(Hand hand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
