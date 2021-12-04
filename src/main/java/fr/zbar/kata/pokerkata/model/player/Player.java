package fr.zbar.kata.pokerkata.model.player;

import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.NullFinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;

import java.util.Objects;

public final class Player {
    private final Name name;
    private final StartingHand startingHand;
    private final FinalHand finalHand;

    private Player(Name name, StartingHand startingHand, FinalHand finalHand) {
        this.name = Objects.requireNonNull(name);
        this.startingHand = Objects.requireNonNull(startingHand);
        this.finalHand = finalHand;
    }

    public static Player of(Name name, StartingHand startingHand) {
        return new Player(name, startingHand, new NullFinalHand());
    }

    public static Player of(Name name, StartingHand startingHand, FinalHand finalHand) {
        return new Player(name, startingHand, finalHand);
    }

    public Player determineStrongestHand() {
        return new Player(name, startingHand, startingHand.determineStrongestHand());
    }

    public Player determineWinner(Player other) {
        return finalHand.isStrongerThan(other.finalHand) ? this : other;
    }

    public String stringifyName() {
        return name.value();
    }

    public Name name() {
        return name;
    }

    public StartingHand startingHand() {
        return startingHand;
    }

    public FinalHand finalHand() {
        return finalHand;
    }
}
