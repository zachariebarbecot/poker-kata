package unit;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.FinalHand;
import fr.zbar.kata.pokerkata.model.hand.HighCardFinalHand;
import fr.zbar.kata.pokerkata.model.hand.PairFinalHand;
import fr.zbar.kata.pokerkata.model.hand.StartingHand;
import fr.zbar.kata.pokerkata.model.player.Name;
import fr.zbar.kata.pokerkata.model.player.Player;
import fr.zbar.kata.pokerkata.model.result.PokerResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PokerResultTest {

    private static final String PLAYER_NAME = "PLAYER_NAME";

    @Test
    void should_display_winner_with_high_card() {
        Player winnerPlayerWithHighCardFinalHand = givenPlayerWithFinalHand(
                new HighCardFinalHand(
                        new Card(Rank.ACE, Suit.HEARTS)
                )
        );
        PokerResult pokerResult = new PokerResult(winnerPlayerWithHighCardFinalHand);

        String result = pokerResult.display();

        String expected = PLAYER_NAME + " wins. - with high card: Ace";
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void should_display_tie_if_no_winner() {
        PokerResult pokerResult = new PokerResult(null);

        String result = pokerResult.display();

        String expected = "Tie.";
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void should_display_winner_with_pair() {
        Player winnerPlayerWithPairFinalHand = givenPlayerWithFinalHand(
                new PairFinalHand(
                        new Card(Rank.KING, Suit.HEARTS),
                        new Card(Rank.KING, Suit.DIAMONDS)
                )
        );
        PokerResult pokerResult = new PokerResult(winnerPlayerWithPairFinalHand);

        String result = pokerResult.display();

        String expected = PLAYER_NAME + " wins. - with pair of: King";
        assertThat(result)
                .isEqualTo(expected);
    }

    private Player givenPlayerWithFinalHand(FinalHand finalHand) {
        StartingHand cclStartingHand = new StartingHand(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.DIAMONDS)
        );
        return Player.of(new Name(PLAYER_NAME), cclStartingHand, finalHand);
    }
}
