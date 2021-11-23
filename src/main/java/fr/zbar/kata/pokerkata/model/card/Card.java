package fr.zbar.kata.pokerkata.model.card;

public record Card(Rank rank, Suit suit) {

    public boolean isStrongerThan(Card card) {
        return rank.isStrongerThan(card.rank);
    }

    public boolean isSameRankOf(Card card) {
        return rank.equals(card.rank);
    }

    public String rankValue() {
        return rank().value();
    }
}
