package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.HighCardFinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;

public class HighCardRule implements Rule {

    @Override
    public FinalHand apply(StartingHand hand) {
        return new HighCardFinalHand(hand.highestCard());
    }

    @Override
    public boolean test(StartingHand hand) {
        return true;
    }
}
