package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.PairFinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;

public class PairRule implements Rule {

    @Override
    public FinalHand apply(StartingHand hand) {
        Card[] cards = hand.highestPair().toArray(new Card[0]);
        return new PairFinalHand(cards[0], cards[1]);
    }

    @Override
    public boolean test(StartingHand hand) {
        return hand.hasPair();
    }
}
