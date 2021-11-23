package unit;

import fr.zbar.kata.pokerkata.model.card.Card;
import fr.zbar.kata.pokerkata.model.card.Rank;
import fr.zbar.kata.pokerkata.model.card.Suit;
import fr.zbar.kata.pokerkata.model.hand.HighCardHand;
import fr.zbar.kata.pokerkata.model.hand.PairHand;
import fr.zbar.kata.pokerkata.model.player.Player;
import fr.zbar.kata.pokerkata.model.result.PokerResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PokerResultTest {

    @Test
    void should_display_winner_with_high_card() {
        Player winnerPlayerWithHighCard = new Player(
                "White",
                new HighCardHand(
                        new Card(Rank.ACE, Suit.HEARTS)
                ));
        PokerResult pokerResult = new PokerResult(winnerPlayerWithHighCard);
        String expected = "White wins. - with high card: Ace";

        String result = pokerResult.display();

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void should_display_tie_if_no_winner() {
        PokerResult pokerResult = new PokerResult(null);
        String expected = "Tie.";

        String result = pokerResult.display();

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void should_display_winner_with_pair() {
        Player winnerPlayerWithPair = new Player(
                "Black",
                new PairHand(
                        new Card(Rank.KING, Suit.HEARTS),
                        new Card(Rank.KING, Suit.DIAMONDS)
                ));
        PokerResult pokerResult = new PokerResult(winnerPlayerWithPair);
        String expected = "Black wins. - with pair of: King";

        String result = pokerResult.display();

        assertThat(result)
                .isEqualTo(expected);
    }
}
