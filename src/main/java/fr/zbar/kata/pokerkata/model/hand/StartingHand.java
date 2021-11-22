package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record StartingHand(Card card1, Card card2, Card card3, Card card4, Card card5) implements Hand {

    public StartingHand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        Objects.requireNonNull(card3);
        Objects.requireNonNull(card4);
        Objects.requireNonNull(card5);
    }
}
