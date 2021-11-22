package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.Objects;

public record Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {

    public Hand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        Objects.requireNonNull(card3);
        Objects.requireNonNull(card4);
        Objects.requireNonNull(card5);
    }
}
