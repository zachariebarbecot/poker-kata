package fr.zbar.kata.pokerkata.model.card;

public record Card(Rank rank, Suit suit) {

    public String rankValue() {
        return rank().value();
    }

    public boolean isStrongerThan(Card card) {
        return rank.isStrongerThan(card.rank);
    }
}
