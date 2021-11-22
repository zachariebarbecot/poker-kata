package fr.zbar.kata.pokerkata.model.hand;

public sealed interface Hand
        permits StartingHand, HighCardHand {

    Hand determinateBestHand();

    int weight();

    boolean isStrongestThan(Hand hand);
}
