package fr.zbar.kata.pokerkata.model.hand;

public sealed interface FinalHand
        permits HighCardFinalHand, NullFinalHand, PairFinalHand {

    boolean isStrongerThan(FinalHand finalHand);

    int weight();
}
