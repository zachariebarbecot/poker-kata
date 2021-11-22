package fr.zbar.kata.pokerkata.model.player;

import fr.zbar.kata.pokerkata.model.hand.Hand;

public record Player(String name, Hand hand) {

    public Player determineBestHand() {
        return new Player(name, hand.determinateBestHand());
    }
}
