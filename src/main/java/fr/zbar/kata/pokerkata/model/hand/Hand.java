package fr.zbar.kata.pokerkata.model.hand;

public sealed interface Hand
        permits HighCardHand, PairHand, StartingHand {

    Hand determinateBestHand();

    int weight();

    boolean isStrongestThan(Hand hand);
}
