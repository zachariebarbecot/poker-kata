package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.hand.Hand;
import fr.zbar.kata.pokerkata.model.hand.PairHand;

public class PairRule implements Rule {

    @Override
    public Hand apply(Hand hand) {
        Card[] cards = hand.highestPair().toArray(new Card[0]);
        return new PairHand(cards[0], cards[1]);
    }

    @Override
    public boolean test(Hand hand) {
        return hand.hasPair();
    }
}
