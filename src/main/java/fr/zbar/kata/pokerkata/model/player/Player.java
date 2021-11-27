package fr.zbar.kata.pokerkata.model.player;

import fr.zbar.kata.pokerkata.model.hand.Hand;

public record Player(Name name, Hand hand) {

    public Player determineStrongestHand() {
        return new Player(name, hand.determineStrongestHand());
    }

    public Player determineWinner(Player other) {
        return hand.isStrongestThan(other.hand) ? this : other;
    }

    public String stringifyName() {
        return name.value();
    }
}
