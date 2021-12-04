package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Rule extends Predicate<StartingHand>, Function<StartingHand, FinalHand> {
}
