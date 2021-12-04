package fr.zbar.kata.pokerkata.model.result;

import fr.zbar.kata.pokerkata.model.hand.HighCardFinalHand;
import fr.zbar.kata.pokerkata.model.hand.PairFinalHand;
import fr.zbar.kata.pokerkata.model.player.Player;

import java.util.Optional;

public record PokerResult(Player winner) {

    private static final String TIE_TEMPLATE = "Tie.";
    private static final String HIGH_HAND_WINNER_TEMPLATE = "%s wins. - with high card: %s";
    private static final String PAIR_HAND_WINNER_TEMPLATE = "%s wins. - with pair of: %s";

    public String display() {
        return Optional.ofNullable(winner)
                .map(this::formatResultByWinnerHand)
                .orElse(TIE_TEMPLATE);
    }

    private String formatResultByWinnerHand(Player player) {
        if (player.finalHand() instanceof HighCardFinalHand hand) {
            return String.format(HIGH_HAND_WINNER_TEMPLATE, player.stringifyName(), hand.cardRankValue());
        }
        if (player.finalHand() instanceof PairFinalHand hand) {
            return String.format(PAIR_HAND_WINNER_TEMPLATE, player.stringifyName(), hand.cardRankValue());
        }
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
