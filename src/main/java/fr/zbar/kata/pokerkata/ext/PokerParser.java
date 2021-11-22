package fr.zbar.kata.pokerkata.ext;

import fr.zbar.kata.pokerkata.model.player.Player;

import java.util.List;

@FunctionalInterface
public interface PokerParser {

    List<Player> parse(String input);
}
