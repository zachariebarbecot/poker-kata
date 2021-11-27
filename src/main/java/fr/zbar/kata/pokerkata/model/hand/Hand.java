package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;

import java.util.List;

public sealed interface Hand
        permits HighCardHand, PairHand, StartingHand {

    default Hand determineStrongestHand() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    default Card highestCard() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    default List<Card> highestPair() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    default boolean isStrongestThan(Hand hand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default boolean hasPair() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Hand strongestHand(Hand strongest) {
        return strongest;
    }

    int weight();
}
