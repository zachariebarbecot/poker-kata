package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.hand.Hand;
import fr.zbar.kata.pokerkata.model.hand.HighCardHand;

public class HighCardRule implements Rule {

    @Override
    public Hand apply(Hand hand) {
        return new HighCardHand(hand.highestCard());
    }

    @Override
    public boolean test(Hand hand) {
        return true;
    }
}
