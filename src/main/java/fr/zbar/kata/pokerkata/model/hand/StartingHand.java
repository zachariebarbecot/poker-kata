package fr.zbar.kata.pokerkata.model.hand;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.hand.rule.RuleEnum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record StartingHand(Card card1, Card card2, Card card3, Card card4, Card card5) implements Hand {

    public StartingHand {
        Objects.requireNonNull(card1);
        Objects.requireNonNull(card2);
        Objects.requireNonNull(card3);
        Objects.requireNonNull(card4);
        Objects.requireNonNull(card5);
    }

    @Override
    public Hand determinateBestHand() {
        return Arrays.stream(RuleEnum.values())
                .map(RuleEnum::rule)
                .filter(rule -> rule.test(this))
                .map(rule -> rule.apply(this))
                .reduce(Hand::strongestHand)
                .orElseThrow(UnsupportedOperationException::new);
    }

    @Override
    public Card highestCard() {
        return Stream.of(card1, card2, card3, card4, card5)
                .max(Comparator.comparing(Card::rank))
                .orElseThrow(UnsupportedOperationException::new);
    }

    @Override
    public boolean hasPair() {
        return Stream.of(card1, card2, card3, card4, card5)
                .collect(Collectors.groupingBy(Card::rank, Collectors.counting()))
                .values().stream()
                .anyMatch(v -> v == 2);
    }

    @Override
    public List<Card> highestPair() {
        return Stream.of(card1, card2, card3, card4, card5)
                .collect(Collectors.groupingBy(Card::rank))
                .values().stream()
                .filter(cardsList -> cardsList.size() == 2)
                .reduce(this::highestPair)
                .orElseThrow(UnsupportedOperationException::new);
    }

    @Override
    public int weight() {
        return 0;
    }

    private List<Card> highestPair(List<Card> firstCardsList, List<Card> secondCardsList) {
        return firstCardsList.get(0).isStrongerThan(secondCardsList.get(0)) ?
                firstCardsList : secondCardsList;
    }
}
