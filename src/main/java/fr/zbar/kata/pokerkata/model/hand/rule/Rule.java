package fr.zbar.kata.pokerkata.model.hand.rule;

import fr.zbar.kata.pokerkata.model.hand.Hand;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface Rule extends Predicate<Hand>, UnaryOperator<Hand> {
}
