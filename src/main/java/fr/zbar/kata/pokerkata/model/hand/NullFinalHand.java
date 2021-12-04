package fr.zbar.kata.pokerkata.model.hand;

public record NullFinalHand() implements FinalHand {

    @Override
    public boolean isStrongerThan(FinalHand finalHand) {
        return false;
    }

    @Override
    public int weight() {
        return 0;
    }
}
