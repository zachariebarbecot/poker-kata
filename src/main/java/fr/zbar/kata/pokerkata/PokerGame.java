package fr.zbar.kata.pokerkata;

import fr.zbar.kata.pokerkata.ext.PokerParser;
import fr.zbar.kata.pokerkata.model.player.Player;
import fr.zbar.kata.pokerkata.model.result.PokerResult;

import java.util.List;

public class PokerGame {

    private final PokerParser parser;

    public PokerGame(PokerParser parser) {
        this.parser = parser;
    }

    public String result(String input) {
        List<Player> players = parser.parse(input);
        return players.stream()
                .map(Player::determineStrongestHand)
                .reduce(Player::determineWinner)
                .map(PokerResult::new)
                .map(PokerResult::display)
                .orElseThrow();
    }
}
