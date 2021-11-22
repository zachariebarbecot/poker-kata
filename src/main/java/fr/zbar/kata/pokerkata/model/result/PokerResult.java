package fr.zbar.kata.pokerkata.model.result;

import fr.zbar.kata.pokerkata.model.hand.HighCardHand;
import fr.zbar.kata.pokerkata.model.player.Player;

import java.util.Optional;

public record PokerResult(Player winner) {

    private static final String TIE_TEMPLATE = "Tie.";
    private static final String HIGH_HAND_WINNER_TEMPLATE = "%s wins. - with high card: %s";

    public String display() {
        return Optional.ofNullable(winner)
                .map(this::formatResult)
                .orElse(TIE_TEMPLATE);
    }

    private String formatResult(Player player) {
        if (player.hand() instanceof HighCardHand hand) {
            return String.format(HIGH_HAND_WINNER_TEMPLATE, player.name(), hand.cardRankValue());
        }
        throw new UnsupportedOperationException("Not implemented yet");
    }
}